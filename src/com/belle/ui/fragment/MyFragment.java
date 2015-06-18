package com.belle.ui.fragment;

import java.io.IOException;
import java.util.List;

import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.belle.R;
import com.belle.common.BaseFragment;

public class MyFragment extends BaseFragment {

	SurfaceView surface;
	SurfaceHolder surfaceHolder;
	
	public MyFragment() {
		super();
		this.text_id = R.string.tab_my;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.my_fragment, container, false);
		surface = (SurfaceView)view.findViewById(R.id.surface);
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		Camera camera = Camera.open();
		camera.setDisplayOrientation(90);
		
		surfaceHolder = surface.getHolder();
		// 创建surfaceholder对象
		surfaceHolder.addCallback(new SurfaceHolderCallback(camera));
		// 设置push缓冲类型，说明surface数据由其他来源提供。而不是用自己的Canvas来绘图，在这里由摄像头来提供数据。
//		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
}

class SurfaceHolderCallback implements SurfaceHolder.Callback {
	
	private Camera mCamera;

	public SurfaceHolderCallback(Camera camera) {
		super();
		this.mCamera = camera;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// 设置预览
		try {
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
		} catch (IOException e) {
			e.printStackTrace();
			// 如果出现异常，释放相机资源并置空
			mCamera.release();
			mCamera = null;
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// 如果相机资源并不为空
//		if (mCamera != null) {
//
//			// 获得相机参数对象
//			Camera.Parameters parameters = mCamera.getParameters();
//			// 获取最合适的参数，为了做到拍摄的时候所见即所得，我让previewSize和pictureSize相等
//			Size previewSize = getOptimalPictureSize(parameters.getSupportedPictureSizes(), 640, 480);
//			Size pictureSize = getOptimalPictureSize(parameters.getSupportedPictureSizes(), 640, 480);
//			System.out.println("---------------------------------------------------------------");
//			System.out.println("previewSize: " + previewSize.width + ", " + previewSize.height);
//			System.out.println("pictureSize: " + pictureSize.width + ", " + pictureSize.height);
//			// 设置照片格式
//			parameters.setPictureFormat(PixelFormat.JPEG);
//			// 设置预览大小
//			parameters.setPreviewSize(previewSize.width, previewSize.height);
//			// 设置自动对焦，先进行判断
//			List<String> focusModes = parameters.getSupportedFocusModes();
//			if (focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
//				parameters.setFocusMode(Parameters.FOCUS_MODE_AUTO);
//			}
//			// 设置图片保存时候的分辨率大小
//			parameters.setPictureSize(pictureSize.width, pictureSize.height);
//			// 给相机对象设置刚才设置的参数
//			mCamera.setParameters(parameters);
//			// 开始预览
//			mCamera.startPreview();
//		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// 停止预览
		mCamera.stopPreview();
		// 释放相机资源并置空
		mCamera.release();
		mCamera = null;
	}
	
	/**
	 * 得到最合适的PictureSize
	 * @param sizes
	 * @param w
	 * @param h
	 * @return
	 */
	public static Size getOptimalPictureSize(List<Size> sizes, int w, int h) {
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if (sizes == null) return null;

        Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        // Try to find an size match aspect ratio and size
        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        // Cannot find the one match the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }
}