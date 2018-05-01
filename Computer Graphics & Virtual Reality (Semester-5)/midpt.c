// Fill a circle using midpoint circle algorithm
#include <graphics.h> 
#include <stdio.h> 
int main() { 
	int x,y,x1,y1,r,m; 
	int gd=DETECT,gm; 
	printf("Enter coordinates of the center\n"); 
	scanf("%d%d",&x1,&y1);
	printf("Enter radius of the circle\n");
	scanf("%d",&r);
	x=0;
	y=r;
	m=1-r;
	initgraph(&gd,&gm,NULL); 
	setbkcolor(WHITE); 
	while(x<=y) {
		putpixel(x1+x,y1+y,RED);
		putpixel(x1-x,y1+y,RED);
		putpixel(x1+x,y1-y,RED);
		putpixel(x1-x,y1-y,RED);
		putpixel(x1+y,y1+x,RED);
		putpixel(x1-y,y1+x,RED);
		putpixel(x1+y,y1-x,RED);
		putpixel(x1-y,y1-x,RED);
		if(m<0) {
			m+=2*x+3;
			x++;
			y=y;
		}
		else {
			m+=2*(x-y)+5;
			x++;
			y--;
		}
	}
	closegraph(); 
	return 0; 
}