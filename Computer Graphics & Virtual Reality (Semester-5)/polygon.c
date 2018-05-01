// Clipping a polygon
#include <graphics.h> 
#include <stdio.h> 
float x,y,X,Y;
void clip(float,float,float,float);
int outcode(float,float);
int main() {
	int gd=DETECT,gm; 
	int i;
	float c[4][2];
	printf("Enter window coordinates\n");
	scanf("%f%f%f%f",&x,&y,&X,&Y);
	printf("Enter cooridinates of the polygon\n");
	for(i=0;i<4;i++)
		scanf("%f%f",&c[i][0],&c[i][1]);
	initgraph(&gd,&gm,NULL); 
	setbkcolor(WHITE); 
	setcolor(RED);
	rectangle(x,x,X,Y);
	for(i=0;i<4;i++)
		clip(c[i][0],c[i][1],c[(i+1)%4][0],c[(i+1)%4][1]);
	delay(5000);
	closegraph();
	return 0;
}
void clip(float ax,float ay,float bx,float by) { 
	int a,b,ab,flag=1;
	float AX,AY,BX,BY,m;
	a=outcode(ax,ay);
	b=outcode(bx,by);
	if(a==0&&b==0) {
		delay(1000);
		line(ax,ay,bx,by);
	}
	else {
		ab=a+b;
		while(ab!=0) {
			if(ab%10==2) {
				flag=0;
				break;
			}
			ab/=10;
		}
		if(flag) {
			flag=0;
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
			delay(1000);
			line(AX,AY,BX,BY);
		}
	}
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