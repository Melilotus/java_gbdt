package org.lidongyu.machinelearning.gbdt;


import java.util.*;

import org.lidongyu.machinelearning.gbdt.*;
import org.lidongyu.machinelearning.gbdt.Data.tuple;
import org.lidongyu.machinelearning.gbdt.Data.tuple.tuple_compare;
import org.lidongyu.machinelearning.gbdt.configure.loss_type;

public class RegressionTree {
	public class node {
		public node left;
		public node right;
		
		public int number_of_feature;
		public Double split_value;
		public Double predict_value;
		public boolean is_leaf;
		
		
		public node(){
			left = null;
			right = null;
			number_of_feature = 0;
			split_value = 0.0;
			predict_value = 0.0;
			is_leaf = false;
		}
	}
	
	public class Returevalue {
		public Double fitnessDouble;
		public Double split_valueDouble;
		
		public Returevalue(){
			fitnessDouble = Double.MAX_VALUE;
			split_valueDouble = 0.0;
		}
	}
	public node root;
	public RegressionTree(){
		root = new node();
	}
	
	public void FitData(ArrayList<Data.tuple> sample, int sample_num, int dep, node rootnode){
	
		if(configure.lossType == loss_type.SQUARED_ERROR) {
			rootnode.predict_value = Average(sample, sample_num);
		} /* else {
			rootnode.predict_value = Loginum(sample,sample_num);  // wait to realize
		}*/
		if(dep == configure.max_depth || sample_num < configure.min_leaf_size) {
			rootnode.is_leaf = true;
			return;
		}
		
		if (FindandSplit(sample, sample_num, rootnode)) {
			
		}
		
	}
	
	public void FindandSplit(ArrayList<Data.tuple> sample, int sample_num, node rootnode) {
		Double purtyDouble = 0.0;
		ArrayList<tuple> useful_sample = (ArrayList<Data.tuple>)sample.subList(0, sample_num);
		int n = configure.featurenum;
		List<Integer> fv = new ArrayList<Integer>();
		for(int i =0; i<n ; ++i) {
			fv.add(i);
		}
		
		if(configure.feature_sample_ratio < 1){
			n = (int) (n * configure.feature_sample_ratio);
			Collections.shuffle(fv);
		}
		for(int j =0 ; j < n ; ++j) {
			Integer fid = fv.get(j);
			Double fitnessDouble = Double.MAX_VALUE;
			Returevalue this_fit = new Returevalue();
		    if(getsplit(useful_sample, sample_num , fid, this_fit)){
		    	if(this_fit.fitnessDouble < fitnessDouble) {
		    		rootnode.number_of_feature = fid;
		    		rootnode.split_value = this_fit.split_valueDouble; 
				
		    	}
		    }
		}
		
	}
	public Double Average(ArrayList<Data.tuple> sample, int sample_num) {
		Double sum =0.0;
		for(int j = 0 ; j < sample_num ; ++j) {
			sum += sample.get(j).target;    // no consider of weight;
		}
		return sum/sample_num;
	}
	
	public boolean getsplit(ArrayList<tuple> sample, int sample_num, Integer fid, Returevalue thisReturevalue) {
		tuple_compare compare_index = new tuple_compare(fid);
		Collections.sort(sample,compare_index);
		
		return true;
	}

}
