import java.util.Random;

int students = 0, time = 0;
int capacity = 80, rows = 8, columns = 10;
int total_time = 180, stop_entering = 45, start_leaving = 90;

void setup() {
  size(960, 540);
  textSize(16);
}

void draw() {
  Random r = new Random();
  if(time<=stop_entering)
    students += r.nextInt(enter())+1;
  if(time>=start_leaving) {
    students -= r.nextInt(leave())+1;
    if(students<0)
      students = 0;
  }
  if(time<=total_time) {
    clear();
    background(211);
    stats();
    classroom();
    seats();
  }
  delay(1000);
}

void classroom() {
  rect(20,10,5,40);
  line(30,30,50,30);
  line(40,25,50,30);
  line(40,35,50,30);
  rect(150,10,330,20);
}

void stats() {
  fill(0);
  int inside = students <= capacity ? students : capacity;
  int outside = students > capacity ? students-capacity : 0;
  text("Time of Simulation - "+(time/60)+" hrs : "+(time%60)+" mins", 650, 50);
  text("Students inside the class - "+inside, 650, 75);
  text("Students waiting outside the class - "+outside, 650, 100);
  time += 5;
}

int enter(){
  if(time<=10)
    return 30;
  else if(time<=30)
    return 15;
  else
    return 5;
}

int leave() {
  if(time<=120)
    return 1;
  else if(time<=150)
    return 5;
  else
    return 30;
}

void seats() {
  int i,j,w,h = 100;
  fill(0,255,0);
  stroke(0);
  for(i = 1; i<=rows; i++) {
    w = 30;
    for(j = 1; j<=columns; j++) {
      if(j%2==1)
        w += 20;
      if((i-1)*10+j>students)
        fill(255);
      ellipse(w, h, 40, 40);
      w += 50;
    }
    h += 50;
  }
}
