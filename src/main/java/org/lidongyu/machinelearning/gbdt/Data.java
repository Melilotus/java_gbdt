package org.lidongyu.machinelearning.gbdt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;




public class Data {
	/*
	 * public class id2feature { public Integer id; public double feature; }
	 */
	public  class tuple  {
		public Double type;
		public Double target;
		public Double weight;
		public List<Double> features;
		
		public tuple() {
			this.type = 0.0;
			this.target = 0.0;
			this.weight= 0.0;
			this.features = new ArrayList<Double>();
			
		}

		public void Settype(Double typenum) {
			this.type = typenum;
			
		}

		public void Setweight(Double weightnum) {
			this.weight = weightnum;
		}
		
		public  Boolean Fromstring(String line) {
			String [] resline = line.split("\t");
			if (resline.length == 3) {
				Double string_type = Double.parseDouble(resline[0]);
				Double string_weight = Double.parseDouble(resline[1]);
				this.Settype(string_type);
				this.Setweight(string_weight);
				String [] feature = resline[2].split(" ");
				if(feature.length == configure.featurenum) {
					for(String feature_each : feature) {
						String [] value = feature_each.split(":");
						if (value.length == 2) {
							this.features.add(Double.parseDouble(value[1]));
						}
					}
				}
				return true;
			} else {
				return false;
			}
			
			
		}
		

		
	
	}
	
	
	public  ArrayList<tuple> DataVec;
	
	public Data() {
		DataVec = new ArrayList<Data.tuple>();
	}
	
	public void CleanDataVec() {
		DataVec.clear();
		
	}
	
	public ArrayList<tuple> getData() {
		return DataVec;
	}
	
	public boolean LoadFromFile(String Filename) {
		File file = new File(Filename);
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                tuple line2tuple = new tuple();
                line2tuple.Fromstring(tempString);
                this.DataVec.add(line2tuple);
            }
            reader.close();
		return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void printData() {
		for(Data.tuple mytuple : DataVec) {
			System.out.println(mytuple.features.toString());
		}
	}
	
	public static void main(String args[]) throws IOException {
		configure.featurenum = 3;
		Data myData = new Data();
		myData.LoadFromFile("C:"+File.separator+"Users"+File.separator+"ldy"+File.separator+"workspace"+File.separator+"gbdttestdata"+File.separator+"train.txt");
		myData.printData();
	}

}
