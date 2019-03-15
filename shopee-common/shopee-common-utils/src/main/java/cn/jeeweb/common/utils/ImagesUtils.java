package cn.shopee.common.utils;

import org.apache.commons.io.FilenameUtils;

/**
 * 
 * All rights Reserved, Designed By www.shopee.cn
 * 
 * @title: ImagesUtils.java
 * @package cn.shopee.common.util
 * @description: 判断判断文件
 * @author: HuLiang
 * @date: 2017年5月22日 下午9:25:14
 * @version V1.0
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */
public class ImagesUtils {

	private static final String[] IMAGES_SUFFIXES = { "bmp", "jpg", "jpeg", "gif", "png", "tiff" };

	/**
	 * 是否是图片附件
	 *
	 * @param filename
	 * @return
	 */
	public static boolean isImage(String filename) {
		if (filename == null || filename.trim().length() == 0)
			return false;
		return ArrayUtils.contains(IMAGES_SUFFIXES, FilenameUtils.getExtension(filename).toLowerCase());
	}

}
