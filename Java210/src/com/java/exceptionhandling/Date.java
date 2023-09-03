package com.java.exceptionhandling;

public class Date {
	  private int dd;
	  private int mm;
	  private int yy;
	  
	  public Date(int dd, int mm, int yy) {
	    this.dd = dd;
	    this.mm = mm;
	    this.yy = yy;
	  }
	  
	  public String toString() {
	    return "Date is " + dd + " " + mm + " " + yy;
	  }
	  
	  public boolean validateDate() {
		  try {
			  	if (((yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0))  {
			  		if((mm==1) && (dd>0&&dd<=31) || (mm==2)&&(dd>0&&dd<=29) || (mm==3) && (dd>0&&dd<=31) || (mm==4) && (dd>0&&dd<=30) || (mm==5) && (dd>0&&dd<=31) || (mm==6) && (dd>0&&dd<=30) || (mm==7) && (dd>0&&dd<=31) || (mm==8) && (dd>0&&dd<=31) ||  (mm==9) && (dd>0&&dd<=30) || (mm==10) && (dd>0&&dd<=31) || (mm==11) && (dd>0&&dd<=30) || (mm==12) && (dd>0&&dd<=31)) {
			  			return true;
			  		}
			  	}
			
			  	if(((yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 != 0)) {
			  		if((mm==1) && (dd>0&&dd<=31) || (mm==2)&&(dd>0&&dd<=28) || (mm==3) && (dd>0&&dd<=31) || (mm==4) && (dd>0&&dd<=30) || (mm==5) && (dd>0&&dd<=31) || (mm==6) && (dd>0&&dd<=30) || (mm==7) && (dd>0&&dd<=31) || (mm==8) && (dd>0&&dd<=31) ||  (mm==9) && (dd>0&&dd<=30) || (mm==10) && (dd>0&&dd<=31) || (mm==11) && (dd>0&&dd<=30) || (mm==12) && (dd>0&&dd<=31)) {
			  			return true;
			  		}
			  	}
			  	else {			  		
			  		throw new InvalidDateException();			  		
			  	}
		  	}	
		  	
		  catch(InvalidDateException ide) {
		  		System.out.println("OOPS Invalid Date Exception");
		  }
		  return false;
	  }
}