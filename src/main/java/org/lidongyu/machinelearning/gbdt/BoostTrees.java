package org.lidongyu.machinelearning.gbdt;

import java.awt.List;
import java.util.ArrayList;

import org.lidongyu.machinelearning.gbdt.Data.tuple;
import org.lidongyu.machinelearning.gbdt.configure.loss_type;

public class BoostTrees {
	
	public RegressionTree [] boostTrees;
	
	public BoostTrees() {
		boostTrees = new RegressionTree[configure.iterations];

	}
	
	public void Fit(ArrayList<tuple> sample) {
		int sample_num = sample.size();
		if(configure.data_sample_ratio < 1) {
			sample_num =  (int) (sample_num*configure.data_sample_ratio);
		}
		
		if(configure.lossType == loss_type.SQUARED_ERROR) {
			for(int i =0 ; i < configure.iterations; ++i) {
				
			}
		}
	}

}
