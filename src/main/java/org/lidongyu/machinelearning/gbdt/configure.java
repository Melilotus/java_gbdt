package org.lidongyu.machinelearning.gbdt;

public class configure {
	
	public static enum loss_type {
		LOG_LIKELY,
		SQUARED_ERROR
	}
	
	public static  int featurenum ;
	public static int max_depth;
	public static int iterations;
	public static Double shinkage;
	public static Double data_sample_ratio;
	public static Double feature_sample_ratio;
	public static int min_leaf_size;
	
	
	public static loss_type lossType;
	
	public configure(){
		featurenum = 1;
		max_depth = 1;
		iterations = 0;
		shinkage = 0.1 ;
		data_sample_ratio = 1.0;
		feature_sample_ratio = 1.0 ;
		min_leaf_size = 0;
		lossType = loss_type.SQUARED_ERROR;
		
	}

}
