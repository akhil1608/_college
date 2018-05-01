// Plot bezier curve
#include <graphics.h> 
#include <stdio.h> 
int main() { 
	int c[4][2],n,i;
	float step,j;
	int gd=DETECT,gm; 
	printf("Enter coordinates of the polygon\n");
	for(i=0;i<4;i++) 
		scanf("%d%d",&c[i][0],&c[i][1]);
	printf("Enter step size (Min 0.1)\n");
	scanf("%f",&step);
	n=(int)(1/step);
	float p[n+1][2];
	p[0][0]=c[0][0];
	p[0][1]=c[0][1];
	p[n][0]=c[3][0];
	p[n][1]=c[3][1];
	for(i=1;i<n;i++) {
		j=i*step;
		p[i][0]=(1-j)*(1-j)*(1-j)*c[0][0]+3*(1-j)*(1-j)*j*c[1][0]+3*(1-j)*j*j*c[2][0]+j*j*j*c[3][0];
		p[i][1]=(1-j)*(1-j)*(1-j)*c[0][1]+3*(1-j)*(1-j)*j*c[1][1]+3*(1-j)*j*j*c[2][1]+j*j*j*c[3][1];
	}
	initgraph(&gd,&gm,NULL); 
	setbkcolor(WHITE); 
	setcolor(RED);
	for(i=0;i<n;i++)
		line(p[i][0],p[i][1],p[i+1][0],p[i+1][1]);
	delay(10000);
	closegraph();
	return 0;
}