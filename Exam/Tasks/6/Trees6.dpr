program Trees6;

{$APPTYPE CONSOLE}

uses
  Windows,
  SysUtils,
  EsConsole in '..\..\..\..\����\EsConsole.pas';

type
  Ttree=^rTree;
  rTree=record
    key:integer;
    left,right:Ttree;
    lTag,rTag:boolean;
    level:integer;
  end;

var y,z: Ttree;
var
  head, root:Ttree;
Procedure AddToTree(var head:Ttree; key,level:integer);
begin
  if  head=nil  then
  begin
    new(head);
    head^.key:=key;
    head^.left:=nil;
    head^.right:=nil;
    head^.lTag:=true;
    head^.rTag:=true;
    head^.level:=level;
  end;
  if head^.key<key then
    AddToTree(head^.right,key,level+1);
  if head^.key>key then
    AddToTree(head^.left,key,level+1);
end;


Procedure SymmetricBypass(head:Ttree);
begin
  if head<>nil then
  begin
    SymmetricBypass(head^.left);
    write(head^.key,' ');
    SymmetricBypass(head^.right);
  end;
end;

Procedure EnterTree(var head:Ttree);
var
  c,key:integer;
  s:string;
begin
 readln(s);
  val(s,key,c);
  while c=0 do
    begin
      AddToTree(head,key,0);
      readln(s);
      val(s,key,c);
    end;
end;


  procedure pram (var x: ttree);
  begin
    if x<>nil then
    begin
    writeln (x^.key);
    pram(x^.left);
    pram(x^.right);
  end;
  end;

procedure pram_print (var x: Ttree);
procedure right_sew  (var p: ttree);
begin
  if y <> nil then
  begin
    if y^.right=nil then
    begin
    y^.rtag:=False;
    y^.right:=p;
  end
  else y^.rtag:=true;
  end;
  y:=p;
end;
begin
  if x<>nil then
  begin
    right_sew(x);
    pram_print(x^.left);
    if x^.rTag=True then pram_print(x^.right);
  end;
end;

procedure obhod_proshiv (var x: Ttree);
var b, b1: boolean;
begin

  b1:=False;
  while x<>head do
  begin


    repeat
        b:=False;
      if b1=false then write (x^.key,' ');
      b1:=false;
      if x^.left<>nil then x:=x^.left else if (x^.right<>nil) and (x^.rTag=True) then x:=x^.right else b:=true;
    until  b;

    while x^.rTag=false do begin
        if x^.right<>nil then x:=x^.right else if x^.left<>nil then x:=x^.left else begin Exit; end;
        if x=head then Exit;
        write (x^.key,' ');
        b1:=true;

      end;
    end;
  end;

  procedure samyi_pravyi (var x: Ttree);
  var b: boolean;
  begin
    repeat
      b:=False;
      if (x^.right<>nil) and (x^.rTag<>False) then x:=x^.right else if (x^.left<>nil)then x:=x^.right else b:=true;
    until  b;
    x^.right:=head;
    x^.rtag:=false;
  end;



begin
  SetConsoleCP(1251);
  SetConsoleOutPutCP(1251);
  writeln('������� ������ (��������� ���� �������� "Enter"):');
  root:=nil;
  EnterTree(root);
  new (head);
  head^.left:=root;
  head^.right:=head;

  writeln('������ �����:');
  writeln;
  y:=nil;
  pram_print (root);
  z:=root;
  samyi_pravyi (z);
  obhod_proshiv (head^.left);

  readln;
end.
