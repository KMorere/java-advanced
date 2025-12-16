package fr.fms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ThreadTime {

	public static void main(String[] args) {
	    DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    for (int count = 1; count <= 5; count++) {
		    Thread thread = new Thread(new MonRunnable(1000, count));
			
		    System.out.println(df.format(new Date()));
		
		    thread.start();
	    }
	}

	private static class MonRunnable implements Runnable {
	    private long delai;
	    private int count;
	
	    public MonRunnable(long delai, int count) {
	      this.delai = delai;
	      this.count = count;
	    }

	    @Override
	    public void run() {
	    	String new_list = "";
    		try {
			    Thread.sleep(delai);
				for(int i = 1; i <= 5; i++) {
			        new_list += ""+count;
			        for (int j = 0; j < count; j++) {
				        new_list += "-";
			        }
				}
				System.out.print(new_list + " ");
			    System.out.println();
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
    	}
    }
}