program Task2;

{$APPTYPE CONSOLE}

uses
  SysUtils,
  EsConsole in '..\..\..\..\����\EsConsole.pas';

type
  TList=^TListItem;
  TListItem=record
    Next:TList;
    Name:string;
    First:real;
    Second:real;
    Third:real;
  end;

var
  Head:TList;
  k, comand:LongInt;

procedure InsertContact(Head:TList);
var
  Q, Current:TList;
begin
  New(Q);
  Write('������� ��� ��������: ');
  Readln(Q^.Name);
  Write('������� ������ ������ ��������: ');
  Readln(Q^.First);
  Write('������� ������ ������ ��������: ');
  Readln(Q^.Second);
  Write('������� ������ ������ ��������: ');
  Readln(Q^.Third);
  Current:=Head;
  while (Current^.Next<>nil) and (Current^.Next^.Name<Q^.Name) do
  begin
    Current:=Current^.Next;
  end;
  Q^.Next:=Current^.Next;
  Current^.Next:=Q;
end;

procedure Print(Head:TList);
var
  Current:TList;
begin
  Current:=Head;
  while Current^.Next<>nil do
  begin
    Current:=Current^.Next;
    if (Current^.First>2) and (Current^.Second>2) and (Current^.Third>2)then
    Writeln(Current^.Name,' ',(Current^.First+Current^.Second+Current^.Third)/3:0:1);
  end;
end;

begin
  New(Head);
  Head^.Next:=nil;
  Writeln('�������� ��������: �������� �������(1), ����� �������� ������(2), �����(3).');
  k:=0;
  while k=0 do
  begin
    readln(comand);
    case comand of
      1: InsertContact(Head);
      3: k:=-1;
      2: Print(Head);
    end;
  end;
end.
