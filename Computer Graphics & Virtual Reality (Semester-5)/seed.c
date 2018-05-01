// Seed fill algorithms; flood fill and boundary fill
#include<graphics.h>
#include<stdio.h>
void bf(int,int,int,int);
void ff(int,int,int);
int main() {
	int gd=DETECT,gm;
	initgraph(&gd,&gm,NULL);
	setbkcolor(WHITE);
	setcolor(RED);
	circle(100,100,50);
	circle(100,100,25);
	ff(100,100,RED);
	bf(70,100,RED,BLUE);
	delay(5000);
	closegraph();
	return 0;
}
void bf(int x,int y, int b,int f) {
	if(getpixel(x,y)!=b&&getpixel(x,y)!=f) {
		putpixel(x,y,f);
		bf(x,y+1,b,f);
		bf(x+1,y,b,f);
		bf(x,y-1,b,f);
		bf(x-1,y,b,f);
	}
}
void ff(int x,int y,int f) {
	if(getpixel(x,y)!=f) {
		putpixel(x,y,f);
		ff(x,y+1,f);
		ff(x+1,y,f);
		ff(x,y-1,f);
		ff(x-1,y,f);
	}
}