
        class Shape{
            protected int length;
            public Shape(int l){length=l;}
            public void draw(){}
        }	


            
        class VertLine extends Shape {

			public VertLine(int l) {
				super(l);
				// TODO Auto-generated constructor stub
			}
			
			public void draw() {
				for(int i=0;i<length;i++) {
					System.out.println('*');
				}
			}
        	
        }
        
        
        class HorzLine extends Shape {

			public HorzLine(int l) {
				super(l);
				// TODO Auto-generated constructor stub
			}
			
			public void draw() {
				for(int i=0;i<length;i++) {
					System.out.print("* ");
				}
			}
			 
        	
        }
        
        
        class DiagonalLine extends Shape {

			public DiagonalLine(int l) {
				super(l);
				// TODO Auto-generated constructor stub
			}

			public void draw() {
				for(int i=0;i<length;i++) {
					
					for(int j=0;j<i;j++) {
						System.out.print(" ");
					}
					System.out.print("*\n");
				}
			}
			 
        }
        
        
        class DiagonalLine2 extends Shape {

			public DiagonalLine2(int l) {
				super(l);
				// TODO Auto-generated constructor stub
			}

			public void draw() {
				for(int i=length;i>0;i--) {
					
					for(int j=i;j>0;j--) {
						System.out.print(" ");
					}
					System.out.print("*\n");
				}
			}
			 
        }
        
        
        class Square extends Shape {

			public Square(int l) {
				super(l);
				// TODO Auto-generated constructor stub
			}

			public void draw() {
				for(int i=0;i<length;i++) {
					
					for(int j=1;j<length;j++) {
						System.out.print("* ");
					}
					System.out.print("*\n");
				}
			}
			 
        }
        
        class Rectangle extends Shape {

        	int breadth;
        	
			public Rectangle(int l, int b) {
				super(l);
				breadth = b;
				// TODO Auto-generated constructor stub
			}

			public void draw() {
				for(int i=0;i<breadth;i++) {
					
					for(int j=1;j<length;j++) {
						System.out.print("* ");
					}
					System.out.print("*\n");
				}
			}
			 
        }
        

 public class DrawTest {
	
	public static void main(String[] args)
	{
	     Shape []s=new Shape [6];
         s[0]=new VertLine(5);
         s[1]=new HorzLine(6);  
         s[2]=new DiagonalLine(6); 
         s[3]=new DiagonalLine2(6); 
         s[4]=new Square(6); 
         s[5]=new Rectangle(10,4); 
         
         for(int j=0;j<6;j++)
         {
                System.out.println("\n\n");
                s[j].draw();
           }
}    }
