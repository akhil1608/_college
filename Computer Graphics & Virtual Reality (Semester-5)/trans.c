// Transformation of a 2D image
#include<graphics.h>
#include<stdio.h>
#include<math.h>
int main() {
	int gd=DETECT,gm;
	int tx,ty,sx,sy,ch,i,j,k;
	double theta,p[3][3]={{0,0,1},{0,0,1},{0,0,1}},pp[3][3]={{0,0,1},{0,0,1},{0,0,1}},tf[3][3];
	printf("Enter cooridinates of the triangle\n");
	for(i=0;i<3;i++)
		scanf("%lf%lf",&p[i][0],&p[i][1]);
	printf("Menu\n1. Translate 2. Scaling 3. Rotation\n");
	scanf("%d",&ch);
	switch(ch) {
		case 1:
			printf("Enter translation across x and y\n");
			scanf("%d%d",&tx,&ty);
			double tra[3][3]={{1,0,0},{0,1,0},{tx,ty,1}};
			for(i=0;i<3;i++)
				for(j=0;j<3;j++)
					tf[i][j]=tra[i][j];
		break;
		case 2:
			printf("Enter scaling factor across x and y\n");
			scanf("%d%d",&sx,&sy);
			double sca[3][3]={{sx,0,0},{0,sy,0},{0,0,1}};
			for(i=0;i<3;i++)
				for(j=0;j<3;j++)
					tf[i][j]=sca[i][j];
		break;
		case 3:
			printf("Enter rotation angle (anticlockwise)\n");
			scanf("%lf",&theta);
			theta/=57.2957;
			double rot[3][3]={{cos(theta),-sin(theta),0},{cos(theta),sin(theta),0},{0,0,1}};
			for(i=0;i<3;i++)
				for(j=0;j<3;j++)
					tf[i][j]=rot[i][j];
		break;
		default: printf("Wrong Option\n"); break;
	}
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			for(k=0;k<3;k++)
				pp[i][j]+=p[i][k]*tf[k][j];
	initgraph(&gd,&gm,NULL);
	setbkcolor(WHITE);
	setcolor(RED);
	for(i=0;i<3;i++)
		line(p[i][0],p[i][1],p[(i+1)%3][0],p[(i+1)%3][1]);
	setcolor(BLUE);
	for(i=0;i<3;i++)
		line(pp[i][0],pp[i][1],pp[(i+1)%3][0],pp[(i+1)%3][1]);
	delay(5000);
	closegraph();
	return 0;
}