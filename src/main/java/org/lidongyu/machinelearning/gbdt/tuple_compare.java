package org.lidongyu.machinelearning.gbdt;

import java.util.Comparator;

import org.lidongyu.machinelearning.gbdt.Data.tuple;

public class tuple_compare implements Comparator<tuple> {
	
	private Integer index;
	
	public tuple_compare(Integer idx) {
		this.index = idx;
		// TODO Auto-generated constructor stub
	}

	public int compare(tuple o1, tuple o2) {
		if (o1.features.get(index) > o2.features.get(index)) {
			return 1;
		} else if(o1.features.get(index) < o2.features.get(index)) {
			return -1;
		} else {
			return 0;
		}
	}
	
}