Program Project1;

{$APPTYPE CONSOLE}

uses
  SysUtils,windows;
  //EsConsole in '..\..\..\..\����\EsConsole.pas';

type
  PTSetOfTask = ^TSetOfTask;
  TDataOfTask = record
    id: integer;
  end;

  TSetOfTask = record
    next: PTSetOfTask;
    data: TDataOfTask;
  end;

  PTStack = ^tstack;
  tstack = record
    data: integer;
    LinkOnNext: PTStack;
  end;

procedure push(var base: PTStack; id: integer);
var
  buf: PTStack;
begin
  if (base = nil) then
    begin
      new(base);
      base^.data := id;
      base^.LinkOnNext := nil;
    end
  else
    begin
      new(buf);
      buf^.data := id;
      buf^.LinkOnNext := base;
      base := buf;
    end;
end;

function pop(var base: PTStack): integer;
begin
  if (base = nil) then
    begin
      result := -1;
      exit;
    end;
  if (base^.LinkOnNext = nil) then
    begin
      result := base^.data;
      base := nil;
    end
  else
    begin
      result := base^.data;
      base := base^.LinkOnNext;
    end;
end;

var
  PFirstTask, Psecondtask, buf1, buf2: PTSetOfTask;
  count: integer;
  buf: TDataOfTask;
  st: PTStack;

procedure AddInTasks(src: TDataOfTask; var base: PTSetOfTask);
var
  buf: PTSetOfTask;
begin
  if (base = nil) then
    begin
      new(base);
      base^.data := src;
      base^.next := nil;
    end
  else
    begin
      buf := PFirstTask;
      while (buf^.next <> nil) do
        buf := buf^.next;
        new(buf^.next);
        buf := buf^.next;
        buf^.data := src;
        buf^.next := nil;
      end;
end;

procedure AddInTask(src: TDataOfTask; var base: PTSetOfTask);
var
  buf: PTSetOfTask;
begin
  if (base = nil) then
    begin
      new(base);
      base^.data := src;
      base^.next := nil;
    end
  else
    begin
      buf := Psecondtask;
      while (buf^.next <> nil) do
        buf := buf^.next;
      new(buf^.next);
      buf := buf^.next;
      buf^.data := src;
      buf^.next := nil;
    end;
end;

procedure DelTasks(var base: PTSetOfTask; id: integer);
var
  buf, temp: PTSetOfTask;

begin
  if (base^.data.id = id) then
    begin
      buf := base;
      base := base^.next;
      dispose(buf);
    end
  else
    begin
      buf := base;
      while (buf^.next^.data.id <> id) do
        begin
          buf := buf^.next;
        end;
      temp := buf^.next;
      buf^.next := buf^.next^.next;
      buf := buf^.next;
      dispose(temp);
end;
end;

var
  i: integer;
  flag: boolean;

begin

  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
writeln('�������� ���-��� ��������� � �������');
readln(count);
st := nil;
PFirstTask := nil;
Psecondtask := nil;
for i := 1 to count do
  begin
    readln(buf.id);
    AddInTasks(buf, PFirstTask);
  end;

writeln('������ ������. ���-�� ���������?');
readln(count);
// Psecondtask

for i := 1 to count do
begin
readln(buf.id);
AddInTask(buf, Psecondtask);
end;

buf1 := PFirstTask;
while (buf1 <> nil) do
begin
push(st, buf1^.data.id);
buf1 := buf1^.next;

end;

buf1 := Psecondtask;

while (buf1 <> nil) do
begin
push(st, buf1^.data.id);
buf1 := buf1^.next;

end;

while (st<>nil) do
begin

write(pop(st):3);
end;

readln;

end.

