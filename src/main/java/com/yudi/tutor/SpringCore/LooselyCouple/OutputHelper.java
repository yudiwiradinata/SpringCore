package com.yudi.tutor.SpringCore.LooselyCouple;

public class OutputHelper {

	IOutputGenerator outputGenerator;

	
	//DI via Setter
	public void setOutputGenerator(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}
	
	//DI via constructor
	/*public OutputHelper(IOutputGenerator outputGenerator) {
		// TODO Auto-generated constructor stub
		this.outputGenerator = outputGenerator;
		
	}*/
	
	public void generateOutput() {
		// TODO Auto-generated method stub
		outputGenerator.generateOutput();
	}
}
