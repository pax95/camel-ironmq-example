package org.apache.camel.ironmq.demo;

import org.apache.camel.main.Main;

public class IronMqExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.enableHangupSupport();
		main.addRouteBuilder(new IronMqExampleRoute());
		main.run();
	}
}
