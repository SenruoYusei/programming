//コース番号押したらそのコースのタイムを計測
//コースごとにサークル変更も？
String[] memberName = {/*選手名*/
"1人目",
"2人目",
"3人目",
"4人目",
"5人目"
};
int distance = 50;//距離
int leps = 8;//本数
int members = memberName.length;
int lapMinute = 1;
int lapSecond = 40;
int intervals = 10;
PrintWriter output;

String menuTitle = distance +"×"+leps+" "+lapMinute+":"+lapSecond;
float start = 0;
float[][] table = new float[leps][members];
int count = 0;
void settings(){
size(displayWidth,displayHeight);
}
void setup(){
background(255);
fill(0);
textAlign(CENTER,CENTER);
int y = year();
int m = month();
int d = day();
int h = hour();
int mi = minute();
int se = second();
String filename = y +"_"+m+"_"+d+"/ "+h+"時"+mi+"分"+se+"秒　";
output = createWriter(filename+","+menuTitle+".csv");
for(int i = 0;i < members;i++){
  output.print(memberName[i]+",");
}
output.println();
/*
String date = y+"/"+m+"/"+d+" "+h+":"+mi+":"+se;
PrintWriter output = createWriter(date+".csv");
output.flush();
output.close();
exit();
*/
}
void draw(){
//background(255);
textSize(128);
pushStyle();
  fill(0,0,255);
  text(menuTitle,width/2,30);
popStyle();
textSize(/*50*/(height - 128)/15    );
fill(0,0,255);
text("Ready",3*width/4,30);
fill(0);
pushStyle();
  PFont font = createFont("Meiryo",50);
  textFont(font);
  for(int i = 0;i < members;i++){
    text(memberName[i],width/(members*2) + width/members * i,125);
  }
popStyle();

/*
for(int i = 0;i < count/members + 1;i++){
  for(int j = 0;j < count - (count/members)*members;j++){
    print("["+i+"]["+j+"]");
    text(table[i][j],250*j,100+100*i);
  }
  println();
}
*/
if(key == ESC || count == members * leps){
  output.flush();
  output.close();
  exit();
}
}
void keyReleased(){
if(key == ' '){
  float difference = ( intervals * (count%members) + (60 * lapMinute + lapSecond) * (count/members))*1000;
  float time = millis();
  table[count/members][count - (count/members)*members] = (time -  start - difference)/1000;
  float value = table[count/members][count - (count/members)*members];
  println("time("+time+") - start("+start+") - difference("+difference+") = "+value);
  String res = int(value/60)+":"+nf(value%60,2,2 );
  //text(table[count/members][count - (count/members)*members],50 + 200 * (count - count/members*members),100+100*(count/members));
  text(res,width/(members*2) + width/members * (count - count/members*members),/*175  +120*(count/members)*/180 + (height - 180)/10   * (count/members));
  output.print(res+",");
  if(count % members == members-1)output.println();
  println(res);
  count++;

}
if(key == ENTER){
  start = millis();
  pushStyle();
  fill(0,0,255);
  text("Go!",3*width/4 + 150,30);
  popStyle();
  println("start = "+start);
}
}
