program Project1;

{$APPTYPE CONSOLE}

{$R *.res}

uses
  System,SysUtils;

{������: �� 2 �������� ������������ ���� � ������� ��� �� �����.

�����������: � �����, ����� ����� ������ ������� (������ ��� � ��������� ����������������)
� ������� �� � �������� �������, �.�. ��� ����, ��������� ������ �������. ������ ������ ��� �� �������}

type TQueue = ^queue;
  queue = record
    data: string;
    next: TQueue;
  end;

procedure output(var headSecond,backSecond: TQueue);
begin
  writeln('Output:');
  while headSecond <> nil do
    begin
      writeln(headSecond^.data);
      headSecond:= headSecond^.next;
    end;
end;

procedure processing(var headFirst, backFirst, headSecond, backSecond: TQueue);
var
  PSecond, temp: TQueue;
  number: byte;
begin
  number:=1;
  while headFirst <> nil do
    begin
      if number = 1 then
        begin
          inc(number);
          new(PSecond);
          PSecond^.next:= nil;
          PSecond^.data:= headFirst^.data;
          headSecond:= Psecond;
          backSecond:= PSecond;
        end
      else
        begin
          new(temp);
          temp^.next:= PSecond;
          PSecond:= temp;
          headSecond:= Psecond;
          PSecond^.data:= headFirst^.data;
        end;
      headFirst:= headFirst^.next;
    end;
end;

procedure input(var headFirst, backFirst: TQueue);
var
  FirstQueue: TQueue;
  inputstring: string;
  number: byte;
begin
  number:= 1;
  writeln('������� �������� �������. ���� ������ ��������� - ������� 0.');
  repeat
    readln(inputstring);
    if inputstring <> '0'  then
      begin
        if number = 1 then
          begin
            inc(number);
            new(FirstQueue);
            FirstQueue^.next:=nil;
            FirstQueue^.data:= inputstring;
            headFirst:= FirstQueue;
            backFirst:= FirstQueue;
          end
        else
          begin
            new(FirstQueue^.next);
            FirstQueue:= FirstQueue^.next;
            FirstQueue^.next:=nil;
            FirstQueue^.data:= inputstring;
            backFirst:= FirstQueue;
          end;
      end;

  until inputstring = '0' ;
end;

procedure main;
var
  headFirst, headSecond,
  backFirst, backSecond: TQueue;
begin
  input(headFirst,backFirst);
  processing(headFirst,backFirst,headSecond,backSecond);
  output(headSecond,backSecond);
end;

begin
  main;
  readln;
end.
