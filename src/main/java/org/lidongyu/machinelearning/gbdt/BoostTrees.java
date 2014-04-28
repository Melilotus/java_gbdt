package org.lidongyu.machinelearning.gbdt;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import org.lidongyu.machinelearning.gbdt.Data.tuple;
import org.lidongyu.machinelearning.gbdt.configure.loss_type;

public class BoostTrees {
	
	public RegressionTree [] boostTrees;
	
	public BoostTrees() {
		boostTrees = new RegressionTree[configure.iterations];
		for(int i = 0 ; i< configure.iterations; ++i){
			boostTrees[i] = new RegressionTree();
		}

	}
	public Double Predict(tuple datapoint, int iter) {

		Double resDouble = 0.0;
		for (int i = 0; i < iter; ++i) {
			resDouble += configure.shinkage * boostTrees[i].Predict(datapoint);
		}
		return resDouble;

	}
	public void Fit(ArrayList<tuple> sample) {
		int sample_num = sample.size();
		if(configure.data_sample_ratio < 1) {
			sample_num =  (int) (sample_num*configure.data_sample_ratio);
		}
		
		if(configure.lossType == loss_type.SQUARED_ERROR) {
			for(int i =0 ; i < configure.iterations; ++i) {
				for(int j = 0 ; j < sample_num ;++j) {
					Double ret = Predict(sample.get(j),i);
					sample.get(j).target = sample.get(j).type - ret;
				}
				
				boostTrees[i].FitData(sample, sample_num);
			}	
		}
	}
	
	public static void main(String args[]) {
		System.out.println("das");
		configure myConfigure  = new configure();
		System.out.println("das");
		myConfigure.featurenum = 3;
		myConfigure.iterations = 300;
		myConfigure.max_depth = 4;
		Data myData = new Data();
		myData.LoadFromFile("C:"+File.separator+"Users"+File.separator+"ldy"+File.separator+"workspace"+File.separator+"gbdttestdata"+File.separator+"train.txt");
		BoostTrees newTrees = new BoostTrees();
		newTrees.Fit(myData.DataVec);
		System.out.println("das");
	}

}
