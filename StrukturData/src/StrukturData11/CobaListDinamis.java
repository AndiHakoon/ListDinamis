/*
 * Copyright 2020 Andi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package StrukturData11;

import java.util.Scanner;

/**
 *
 * @author Andi
 */
class NilaiMatKul{
String nim;
String nama;
String nilai;

NilaiMatKul(){
}

void setNim(String nim){
this.nim = nim;
}

String getNim(){
return nim;
}

void setNama(String nama){
this.nama = nama;
}

String getNama(){
return nama;
}

void setNilai(String nilai){
this.nilai = nilai;
}

String getNilai(){
return nilai;
}
}

class Elemen{
NilaiMatKul kontainer;
Elemen next;

Elemen(){
kontainer = new NilaiMatKul();
}

NilaiMatKul getKontainer(){
return kontainer;
}

void setNext(Elemen next){
this.next = next;
}

Elemen getNext(){
return next;
}
}

class List{
private Elemen first;

List(){
}

void setFirst(Elemen first){
this.first = first;
}

Elemen getFirst(){
return first;
}

void createList(){
first = null;
}

int countElement(){
int hasil=0;
Elemen bantu;

if(first != null){
//list tidak kosong
bantu = first;
while(bantu != null){
hasil = hasil+1;
bantu = bantu.getNext();
}
}
return hasil;
}

void addFirst(String nim, String nama, String nilai){
Elemen baru;
baru = new Elemen();
baru.getKontainer().setNim(nim);
baru.getKontainer().setNama(nama);
baru.getKontainer().setNilai(nilai);

if(first == null){
//list kosong
baru.setNext(null);
}
else{
//list tidak kosong
baru.setNext(first);
}
first = baru;
baru = null;
}

void addAfter(Elemen prev,String nim, String nama, String nilai){
Elemen baru;
if(prev != null){
baru = new Elemen();
baru.getKontainer().setNim(nim);
baru.getKontainer().setNama(nama);
baru.getKontainer().setNilai(nilai);

if(prev.next == null){
baru.setNext(null);
}
else{
baru.setNext(prev.getNext());
}
prev.setNext(baru);
baru = null;
}
}

void addLast(String nim, String nama, String nilai){
Elemen last;
if(first == null){
//listkosong
addFirst(nim,nama,nilai); //panggil addFirst
}
else {
//jika list sudah terisi
//cari elemen terakhir
last = first;
while(last.getNext() != null){
last = last.getNext();
}
addAfter(last,nim,nama,nilai);
}
}

void delFirst(){
Elemen hapus;
if(first != null){ //tidak kosong
hapus = first;
if(countElement()==1){ //satu elemen saja
first = null;
}
else{ //lebih dari 1
first = first.getNext();
}
//kosongkan elemen awal sebelumnya
hapus.setNext(null);
}
else{ //list kosong
System.out.println("List Kosong, tidak bisa dihapus");
}
}

void delAfter(Elemen prev){
Elemen hapus;
if(prev != null){
hapus = prev.getNext();
if(hapus != null){
if(hapus.getNext() == null){
prev.setNext(null);
}
else{
prev.setNext(hapus.getNext());
}
//pengosongan elemen
hapus.setNext(null);
}
}
}

void delLast(){
Elemen last, before_last;
if(first != null){
if(countElement()==1){
//list isi hanya satu
delFirst();
}
else{ //mencari elemen terakhir
last = first;
before_last = null;
while(last.getNext()!= null){
before_last = last;
last = last.getNext();
}
//elemen sebelum menjadi elemen terakhir
delAfter(before_last);
}
}
}

void printElement(){
Elemen bantu;
int i;
if(first != null){
bantu = first;
i=1;
while(bantu != null){
System.out.println("Elemen ke : " +i);
System.out.println("Nim : " + bantu.getKontainer()
.getNim());
System.out.println("Nama : " + bantu.getKontainer()
.getNama());
System.out.println("Nilai : " + bantu.getKontainer()
.getNilai());
System.out.println("----------------------");
bantu = bantu.getNext();
i=i+1;
}
}
else{
//list kosong
System.out.println("List Kosong. Data tidak ada");
}
}

void delAll(){
int i;
if(countElement()!=0){
for(i=countElement();i>=1;i--){
//elemen dihapus daru belakang
delLast();
}
}
}
}

public class CobaListDinamis {
public static void main(String[] args) {

String katacari;
Elemen bantu;
int i;
Scanner in = new Scanner(System.in);

List L1 = new List();

L1.createList();
System.out.println("===Insert===");
L1.addFirst("136","Nana","A");
L1.addAfter(L1.getFirst(),"135","Iza","A");
L1.addLast("137","Rara","A");
L1.addFirst("131","Koko","B");
L1.printElement();
System.out.println("===================");


System.out.print("Masukkan nim yang akan dicari :");
katacari = in.nextLine();

bantu = L1.getFirst();
i=1;
while((bantu != null)&&(!bantu.kontainer.getNim().equals(katacari)) ){
bantu = bantu.getNext();
i=i+1;
}
if (bantu == null){
System.out.println("Data tidak ditemukan");
}
else{
System.out.println("===Hasil Pencarian===");
System.out.println(" Elemen ke: "+i);
System.out.println(" NIM = "+bantu.kontainer.getNim());
System.out.println(" Nama = "+bantu.kontainer.getNama());
System.out.println(" Nilai = "+bantu.kontainer.getNilai());
}

System.out.println("\n===Delete===");
L1.delFirst();
L1.delAfter(L1.getFirst());
L1.delLast();
L1.printElement();
System.out.println("===================");
}
}