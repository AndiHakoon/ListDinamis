#include iostream.h

// boolean.h
# ifndef __boolean__
# define __boolean__
# define true 1
# define false 0
# define boolean unsigned char
# endif

//jam.h
#ifndef jam_h
#define jam_h
#include “boolean.h”

/*definisi ADT jam*/
typedef struct{
int hh; /*jam*/
int mm; /*menit*/
int ss; /*sekon*/
}jam;

/*definisi prototipe primitif*/
/***konstruktor membentuk jam***/
jam makeJam(int hh, int mm, int ss);
/*IS:jam belum terbentuk
FS:telah terbentuk jam dengan nilai jam, menit, dan sekon (komponen-komponennya)
membentuk sebuah jam dari komponen-komponennya*/

/***selektor jam***/
int getHH(jam j);
/*IS:nilai jam belum diketahui
FS:nilai jam diketahui
mengirimkan komponen jam dari j*/

int getMM(jam j);
/*IS:nilai menit belum diketahui
FS:nilai menit diketahui
mengirimkan komponen menit dari j*/

int getSS(jam j);
/*IS:nilai sekon belum diketahui
FS:nilai sekon diketahui
mengirimkan komponen sekon dari j*/

/***destruktor/dealokator tidak perlu***/

/***set nilai komponen jam***/
void setHH(jam *j, int newHH);
/*IS:nilai jam pada sebuah titik J,sembarang
FS:nilai jam titik J berubah menjadi nilai xbaru
men-set komponen jam dari j*/

void setMM(jam *j, int newMM);
/*IS:nilai menit pada sebuah titik J,sembarang
FS:nilai menit titik J berubah menjadi nilai xbaru
men-set komponen menit dari j*/

void setSS(jam *j, int newSS);
/*IS:nilai sekon pada sebuah titik J,sembarang
FS:nilai sekon titik J berubah menjadi nilai xbaru
men-set komponen sekon dari j*/

/*kelompok validasi terhadap type*/
boolean isJamValid(jam j);
/*IS:valid jam belum di ketahui
FS:valid jam sudah diketahui
mengirimkan validitas dari j*/

/*kelompok interaksi dengan I/O device, baca/tulis*/
void bacaJam(jam *j);
/*IS:jam belum ada
FS:jam terbentuk dengan nilai jam, menit, dan sekon sesuai dengan inputan user
baca jam (hh,mm,ss) membentuk j dari hh, mm, dan ss yang dibaca*/

void tulisJam(jam j);
/*IS:jam sudah ada
FS:posisi jam ditampilkan dilayar
nilai j ditulis ke layar dg format (HH, MM, SS)*/

/*kelompok konversi terhadap type*/
int jamToDetik(jam j);
/*IS:telah ada jam yang terbentuk j
FS:menghasilkan sebuah jam yang merupakan hasil konversi dari jam j
menghasilkan salinan j yang berisi konversi ke detik*/

jam detikToJam(int n);
/*IS:telah ada detik yang terbentuk n
FS:menghasilkan sebuah jam yang merupakan hasil konversi dari int n
menghasilkan jam j yang berisi konversi ke jam*/

/***kelompok operasi terhadap type***/
boolean JEQ(jam j1, jam j2);
/*IS:telah ada dua jam yaitu j1 dan j2
FS:mengirimkan true jika j1=j2*/

boolean JNEQ(jam j1, jam j2);
/*IS:telah ada dua jam yaitu j1 dan j2
FS:mengirimkan true jika j1 tidak sama dengan j2*/

boolean JLT(jam j1, jam j2);
/*IS:telah ada dua jam yaitu j1 dan j2
FS:mengirimkan true jika j1=j2
definisi lebih besar*/

/***operator aritmatika jam***/
jam jPlus(jam j1, jam j2);
/*IS:telah ada dua jam yang terbentuk j1 dan j2
FS:menghasilkan sebuah jam yang merupakan hasil penjumlahan dari jam j1 dengan jam j2
menghasilkan salinan j yang berisi j1+j2*/

jam jMinus(jam j1, jam j2);
/*IS:telah ada dua jam yang terbentuk j1 dan j2
FS:menghasilkan sebuah jam yang merupakan hasil pengurangan dari jam j1 dengan jam j2
menghasilkan salinan j yang berisi j1-j2
precond:j1jAkh*/

#endif

//jam.c
#include “boolean.h”
#include “JAM.H”

/*definisi prototipe primitif*/
/***konstruktor membentuk jam***/
jam makeJam(int hh, int mm, int ss){
jam j;
j.hh=hh;
j.mm=mm;
j.ss=ss;
return j;
}
/*IS:jam belum terbentuk
FS:telah terbentuk jam dengan nilai jam, menit, dan sekon (komponen-komponennya)
membentuk sebuah jam dari komponen-komponennya*/

/***selektor jam***/
int getHH(jam j){
return j.hh;
}
/*IS:nilai jam belum diketahui
FS:nilai jam diketahui
mengirimkan komponen jam dari j*/

int getMM(jam j){
return j.mm;
}
/*IS:nilai menit belum diketahui
FS:nilai menit diketahui
mengirimkan komponen menit dari j*/

int getSS(jam j){
return j.ss;
}
/*IS:nilai sekon belum diketahui
FS:nilai sekon diketahui
mengirimkan komponen sekon dari j*/

/***destruktor/dealokator tidak perlu***/

/***set nilai komponen jam***/
void setHH(jam *j, int newHH){
(*j).hh=newHH;
}
/*IS:nilai jam pada sebuah titik J,sembarang
FS:nilai jam titik J berubah menjadi nilai xbaru
men-set komponen jam dari j*/

void setMM(jam *j, int newMM){
(*j).mm=newMM;
}
/*IS:nilai menit pada sebuah titik J,sembarang
FS:nilai menit titik J berubah menjadi nilai xbaru
men-set komponen menit dari j*/

void setSS(jam *j, int newSS){
(*j).ss=newSS;
}
/*IS:nilai sekon pada sebuah titik J,sembarang
FS:nilai sekon titik J berubah menjadi nilai xbaru
men-set komponen sekon dari j*/

/*kelompok validasi terhadap type*/
boolean isJamValid(jam j){
if(j.hh<24 && j.mm<60 && j.ss<60)
return true;
else
return false;
}
/*IS:valid jam belum di ketahui
FS:valid jam sudah diketahui
mengirimkan validitas dari j*/

/*kelompok interaksi dengan I/O device, baca/tulis*/
void bacaJam(jam *j){
printf("nilai hour :");
scanf("%d",&(*j).hh);
printf("nilai minute :");
scanf("%d",&(*j).mm);
printf("nilai second :");
scanf("%d",&(*j).ss);
}
/*IS:jam belum ada
FS:jam terbentuk dengan nilai jam, menit, dan sekon sesuai dengan inputan user
baca jam (hh,mm,ss) membentuk j dari hh, mm, dan ss yang dibaca*/

void tulisJam(jam j){
printf("(%d,%d,%d)\n",j.hh,j.mm,j.ss);
}
/*IS:jam sudah ada
FS:posisi jam ditampilkan dilayar
nilai j ditulis ke layar dg format (HH, MM, SS)*/

/*kelompok konversi terhadap type*/
int jamToDetik(jam j){
return 3600*j.hh+60*j.mm+j.ss;
}
/*IS:telah ada jam yang terbentuk j
FS:menghasilkan sebuah jam yang merupakan hasil konversi dari jam j
menghasilkan salinan j yang berisi konversi ke detik*/

jam detikToJam(int n){
jam j;
j.hh=n/3600;
j.mm=(n%3600)/60;
j.ss=(n%3600)%60;
return j;
}
/*IS:telah ada detik yang terbentuk n
FS:menghasilkan sebuah jam yang merupakan hasil konversi dari int n
menghasilkan jam j yang berisi konversi ke jam*/

/***kelompok operasi terhadap type***/
boolean JEQ(jam j1, jam j2){
if(j1.hh==j2.hh && j1.mm==j2.mm && j1.ss==j2.ss)
return true;
else
return false;
}
/*IS:telah ada dua jam yaitu j1 dan j2
FS:mengirimkan true jika j1=j2*/

boolean JNEQ(jam j1, jam j2){
if(j1.hh==j2.hh && j1.mm==j2.mm && j1.ss==j2.ss)
return false;
else
return true;
}
/*IS:telah ada dua jam yaitu j1 dan j2
FS:mengirimkan true jika j1 tidak sama dengan j2*/

boolean JLT(jam j1, jam j2){
if(j1.hh<j2.hh)
return true;
else
return false;
}
/*IS:telah ada dua jam yaitu j1 dan j2
FS:mengirimkan true jika j1j2.hh)
return true;
else
return false;
}
/*IS:telah ada dua jam yaitu j1 dan j2
FS:mengirimkan true jika j1>=j2
definisi lebih besar*/

/***operator aritmatika jam***/
jam jPlus(jam j1, jam j2){
jam j;
j.hh=j1.hh+j2.hh;
j.mm=j1.mm+j2.mm;
j.ss=j1.ss+j2.ss;
if(j.ss>=60){
j.ss=j.ss%60;
j.mm=j.mm+1;
if(j.mm>=60){
j.mm=j.mm%60;
j.hh=j.hh+1;
if(j.hh>=24)
j.hh=j.hh%24;
}
else if(j.hh>=24)
j.hh=j.hh%24;
}
return j;
}
/*IS:telah ada dua jam yang terbentuk j1 dan j2
FS:menghasilkan sebuah jam yang merupakan hasil penjumlahan dari jam j1 dengan jam j2
menghasilkan salinan j yang berisi j1+j2*/

jam jMinus(jam j1, jam j2){
jam j;
j.hh=j2.hh-j1.hh;
j.mm=j2.mm-j1.mm;
j.ss=j2.ss-j1.ss;
    if(j.ss<0){
        j.ss=j.ss+60;
        j.mm=j.mm-1;

    if(j.mm<0){
    j.mm=j.mm+60;
    j.hh=j.hh-1;

        if(j.hh<0)
        j.hh=j.hh+24;
        }
    }
else if(j.mm<0){
j.mm=j.mm+60;
j.hh=j.hh-1;
if(j.hh<0)
j.hh=j.hh+24;
}
else if(j.hh<0)
j.hh=j.hh+24;
return j;
}
/*IS:telah ada dua jam yang terbentuk j1 dan j2
FS:menghasilkan sebuah jam yang merupakan hasil pengurangan dari jam j1 dengan jam j2
menghasilkan salinan j yang berisi j1-j2
precond:j1=60){
j.ss=j.ss%60;
j.mm=j.mm+1;
if(j.mm>=60){
j.mm=j.mm%60;
j.hh=j.hh+1;
if(j.hh>=24)
j.hh=j.hh%24;
}
else if(j.hh>=24)
j.hh=j.hh%24;
}
return j;
}
/*IS:telah ada satu jam dengan nilai detik tertentu
FS:mengirim salinan j dengan detik ditambah satu*/

jam nextNDetik(jam j, int n){
int mmTemp;
j.ss=j.ss+n;
if(j.ss>=60){
j.ss=j.ss%60;
j.mm=j.mm+(n/60);
mmTemp=j.mm;
if(j.mm>=60){
j.mm=j.mm%60;
j.hh=j.hh+(mmTemp/60);
if(j.hh>=24)
j.hh=j.hh%24;
}
else if(j.hh>=24)
j.hh=j.hh%24;
}
return j;
}
/*IS:telah ada satu jam dengan nilai detik tertentu
FS:mengirim salinan j dengan detik ditambah n*/

jam prevDetik(jam j){
j.ss=j.ss-1;
return j;
}
/*IS:telah ada satu jam dengan nilai detik tertentu
FS:mengirim salinan j dengan detik dikurangi satu*/

jam prevNDetik(jam j, int n){
j.ss=j.ss-n;
while(j.ss<0){
j.ss=j.ss+60;
j.mm=j.mm-1;
if(j.mm<0){
j.mm=j.mm+60;
j.hh=j.hh-1;
if(j.hhjAkh*/

//driver.c
#include “JAM.H”
#include “BOOLEAN.H”
#include

void main(){
jam j,j1,j2;
boolean bo;
int hh,mm,ss;
int n;

puts(“coba membuat jam dngan makeJam”);
j=makeJam(12,30,30);
tulisJam(j);

printf(“melihat hour j\t”);
printf(“%d\n”,getHH(j));

printf(“melihat minute j\t”);
printf(“%d\n”,getMM(j));

printf(“melihat second j\t”);
printf(“%d\n”,getSS(j));
tulisJam(j);

puts(“\nmengubah hour j”);
printf(“masukkan jam baru= “);
scanf(“%d”,&hh);
setHH(&j,hh);
tulisJam(j);

puts(“\nmengubah minute j”);
printf(“masukkan menit baru= “);
scanf(“%d”,&mm);
setMM(&j,mm);
tulisJam(j);

puts(“\nmengubah second j”);
printf(“masukkan detik baru= “);
scanf(“%d”,&ss);
setSS(&j,ss);
tulisJam(j);

if(isJamValid(j)){
puts(“\njam j adalah valid”);
};

printf(“\njam ke detik = %d detik\n”,jamToDetik(j));

getch();
puts(“\n\nmencoba membuat jam dg cara manual”);

puts(“masukkan j1”);
bacaJam(&j1);
printf(“\nj1=”);
tulisJam(j1);

getch();
puts(“\nmasukkan j2”);
bacaJam(&j2);
printf(“\nj2=”);
tulisJam(j2);

getch();
if(JEQ(j1,j2)){
puts(“kedua jam equal\n”);
};

if(JNEQ(j1,j2)){
puts(“kedua jam tidak equal\n”);
};

if(JLT(j1,j2)){
puts(“j1 lebih rendah dari j2\n”);
};

if(JGT(j1,j2)){
puts(“j1 lebih tinggi dari j2\n”);
};

getch();
printf(“\nj1+j2=”);
j=jPlus(j1,j2);
tulisJam(j);

getch();
if(JEQ(j1,j2)||JLT(j1,j2)){
printf(“\nj1-j2=”);
j=jMinus(j1,j2);
}
else
puts(“\nkarena j1>j2 maka jMinus tidak dapat di run”);
tulisJam(j);

getch();
printf(“\njam j ditambah 1 detik=”);
j=nextDetik(j);
tulisJam(j);

getch();
printf(“\njam j ditambah n detik=”);
printf(“\nmasukkan detik n=”);
scanf(“%d”,&n);
j=nextNDetik(j,n);
tulisJam(j);

getch();
printf(“\njam j dikurangi 1 detik=”);
j=prevDetik(j);
tulisJam(j);

getch();
printf(“\njam j dikurangi n detik=”);
printf(“\nmasukkan detik n=”);
scanf(“%d”,&n);
j=prevNDetik(j,n);
tulisJam(j);

getch();
puts(“\nmencoba menghitung durasi”);
printf(“\njAw=”);
tulisJam(j1);

getch();
printf(“\njAkh=”);
tulisJam(j2);

printf(“\ndurasi = %d detik\n”,durasi(j1,j2));

printf(“\ndetik ke jam = (%d,%d,%d)”,detikToJam(durasi(j1,j2)));

getch();
}
