
package lesson1;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
 
public class tetris {
	
	 String[][] a = new String[100][100];
	 //int r=30,c=60;
	 int[] x=new int[10];
	 int[] y=new int[10];
	 tetris() {
		 x[0]=0;
		 y[0]=0;
	 }
	
	public static void main(String args[] ) throws IOException
	{
		char[][] a=new char[100][100];
		int ch;
		int[][] mat=new int[10][10];
		Scanner ss = new Scanner(System.in);
		
			
		
			Board b = new Board();
			b.set_matrix(a);
		
		int m_r=20,m_c=20;
		tetris t=new tetris();
		shape s=new shape();
		
		Point p=new Point();
		int n=p.values(a);
		
		s.jump(n,a);
		
			
	}
}
class Point{
	
	char val;
	
	Point(){
		
	}
	public static int values(char[][] a) {
		 Random rand = new Random(); 
		
		int ran = rand.nextInt(4);
		
		int[] x=new int[4];
		int[] y=new int[4];
		int i,k,j,r=15,c=31;
		if(ran==1) {
		x[0]=0;y[0]=14;
		x[1]=0;y[1]=15;
		x[2]=1;y[2]=14;
		x[3]=1;y[3]=15;
		}
		if(ran==2) {
		x[0]=0;y[0]=15;
		x[1]=1;y[1]=14;
		x[2]=1;y[2]=15;
		x[3]=1;y[3]=16;
		}
		if(ran==3) {
		x[0]=0;y[0]=15;
		x[1]=1;y[1]=15;
		x[2]=2;y[2]=15;
		x[3]=2;y[3]=16;
		}
		if(ran==0) {
		x[0]=0;y[0]=13;
		x[1]=0;y[1]=14;
		x[2]=0;y[2]=15;
		x[3]=0;y[3]=16;
		}
		//System.out.print("ye vala");
		System.out.println();
		for(i=0;i<r;i++)
			for(k=0;k<c;k++) {
				
			for(j=0;j<4;j++) {
				if(x[j]==i && y[j]==k)
					a[i][k]='#';
			}
				System.out.print(a[i][k]);
	}
		for(i=0;i<r;i++)
			for(k=0;k<c;k++) 
				
			for(j=0;j<4;j++) {
				if(x[j]==i && y[j]==k)
					a[i][k]=' ';
			}
		return ran;
	}
	
}
class shape extends Point{
	shape(){
		
	}
	public static void jump(int n,char[][] a1) 
	{
		int[][] a=new int[100][100];
		int[] step=new int[100];
		int i,j,t=1,k=0,r=15,c=31,flag=0,p;
		int c_r=13,c_c=0;
		
		Scanner s = new Scanner(System.in);
		while(t!=0) {
		 t=s.nextInt();
		flag=0;
		{
		if(t==2) {
			c_c++;
		for(i=0;i<2;i++) {
		
			for(j=0;j<4;j++) {
				
				if(i==1)
					a[i][j]=c_r+j;
				else
					a[i][j]=c_c;
			}
		}
		}
		if(t==1) {
			c_r--;
			for(i=0;i<2;i++) {
				for(j=0;j<4;j++) {
					
					if(i==1)
						a[i][j]=c_r+j;
					else
						a[i][j]=c_c;
				}
			}
			
		}
		if(t==3) {
			c_r++;
			for(i=0;i<2;i++) {
				for(j=0;j<4;j++) {
					
					if(i==1)
						a[i][j]=c_r+j;
					else
						a[i][j]=c_c;
				}
			}
			//c_r++;
		}
		if(t==5) {
			c_c--;
			for(i=0;i<2;i++) {
				
				for(j=0;j<4;j++) {
					
					if(i==1)
						a[i][j]=c_r+j;
					else
						a[i][j]=c_c;
				}
			}
		}
		}
int l=a[0][0];
int ll=a[1][0];
		//System.out.print(l+" "+ll);
		System.out.println();
		for(i=0;i<r;i++)
			for(k=0;k<c;k++) {
				
			for(j=0;j<4;j++) {
				if(a[0][j]==i && a[1][j]==k)
					a1[i][k]='#';
			}
				System.out.print(a1[i][k]);
	}
 if(a1[l+1][ll]!=' ' || a1[l+1][ll+1]!=' ' || a1[l+1][ll+2]!=' ' || a1[l+1][ll+3]!=' ') {
	step[l]=step[l]+4;
	 flag=1;
	 //System.out.println(l+"---"+step[l]);
		//System.out.print("flag");
		System.out.println();
		
	
 }else {

	 for(i=0;i<r;i++)
			for(k=0;k<c;k++) 
				
			for(j=0;j<4;j++) {
				if(a[0][j]==i && a[1][j]==k)
					a1[i][k]=' ';
			}
		 }
 if(flag==1) {
	 if(step[l]==28) {
		for(k=l;k>0;k--) {
			for(j=0;j<c;j++) {
				a1[k][j]=a1[k-1][j];
			}
		}
		}
	p=values(a1);
	c_r=13;c_c=0;
 }
		}
		
		
		
		
	}
	
}
class Board {
	Board() {
	    System.out.println("");
	  }
	 
	public static void set_matrix(char[][] a) {
		int k=0,flag=0,i=0;
		int r=15,c=31;
		while(i<r) {
			k=0;
			while(k<c){
	            flag=0;
	            if(i==r-1)
	            a[i][k]='-';
	    else if(k==0 || k==c-2 )
	            a[i][k]='|';
	    else {
	    	
	    	if(flag==0)
	    		 
	    	a[i][k]=' ';
	    }
	            k++;
		}
			a[i][k-1]='\n';
			i++;
		}
		
	  }
	}
