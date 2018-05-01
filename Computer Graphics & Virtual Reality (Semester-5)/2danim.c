// Simple 2D animation of a car moving across a screen
#include <graphics.h>
int main() {
	int gd=DETECT,gm;
	initgraph(&gd,&gm,NULL);
	int x3=20,x4=60,y=40,x1=0,x2=80,y1=10,y2=40;
	setbkcolor(WHITE);
	setcolor(RED);
	while(x2!=300) {
		cleardevice();
		circle(x3,y,10);
		circle(x4,y,10);
		rectangle(x1,y1,x2,y2);
		delay(100);
		x1+=5;
		x2+=5;
		x3+=5;
		x4+=5;
	}
	closegraph();
	return 0;
}