// Line clipping using outcodes
#include <graphics.h> 
#include <stdio.h> 
float x,y,X,Y;
int outcode(float,float);
int main() { 
	int a,b,ab,flag=0;
	float ax,ay,bx,by,AX,AY,BX,BY,m;
	int gd=DETECT,gm; 
	printf("Enter window coordinates\n");
	scanf("%f%f%f%f",&x,&y,&X,&Y);
	printf("Enter line coordinates\n");
	scanf("%f%f%f%f",&ax,&ay,&bx,&by);
	a=outcode(ax,ay);
	b=outcode(bx,by);
	initgraph(&gd,&gm,NULL); 
	setbkcolor(WHITE); 
	setcolor(RED);
	rectangle(x,x,X,Y);
	if(a==0&&b==0) {
		line(ax,ay,bx,by);
		delay(5000);
		closegraph();
		return 0;
	}
	ab=a+b;
	while(ab!=0) {
		if(ab%10==2) {
			line(ax,ay,bx,by);
			delay(5000);
			closegraph();
			return 0;
		}
		ab/=10;
	}
	m=(by-ay)/(bx-ax);
	if(!a) {
		AY=ay;
		AX=ax;
	}
	else {
		if(a%10) {
			AY=m*(x-ax)+ay;
			AX=x;
			flag=1;
		}
		if((a/10)%10) {
			AY=m*(X-ax)+ay;
			AX=X;
			flag=1;
		}
		if(outcode(AX,AY)||!flag) {
			if((a/100)%10) {
			AX=(y-ay)/m+ax;
			AY=y;
		}
		if((a/1000)%10) {
			AX=(Y-ay)/m+ax;
			AY=Y;
		}
	}
	flag=0;
	if(!b) {
		BY=by;
		BX=bx;
	}
	else {
		if(b%10) {
			BY=m*(x-bx)+by;
			BX=x;
			flag=1;
		}
		if((b/10)%10) {
			BY=m*(X-bx)+by;
			BX=X;
			flag=1;
		}
		if(outcode(BX,BY)||!flag) {
			if((b/100)%10) {
				BX=(y-by)/m+bx;
				BY=y;
			}
			if((b/1000)%10) {
				BX=(Y-by)/m+bx;
				BY=Y;
			}
		}
	}
	line(AX,AY,BX,BY);
	delay(10000);
	closegraph();
	return 0;
}
int outcode(float p,float q) {
	int o=0;
	if(p<x)
		o=o+1;
	if(p>X)
		o=o+10;
	if(q<y)
		o=o+100;
	if(q>Y)
		o=o+1000;
	return o;
}