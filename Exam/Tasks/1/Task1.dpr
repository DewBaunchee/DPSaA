program Task1;

{$APPTYPE CONSOLE}

uses
  SysUtils,
  Windows;
 // EsConsole in '..\..\..\..\����\EsConsole.pas';

type
  PTreeEl = ^TreeEl;
  TreeEl = record
    data: integer;
    sum: integer;
    left: PTreeEl;
    right: PTreeEl;
  end;


procedure AddElem(var head: PTreeEl; data: integer);
begin
  if (head = nil) then
  begin
    New(head);
    head^.left := nil;
    head^.right := nil;
    head^.data := data;
    head^.sum := 0;
  end
  else
    if (data < head^.data) then
      AddElem(head^.left, data)
    else
      if (data > head^.data) then
        AddElem(head^.right, data);
end;

function CountSum(head: PTreeEl): integer;
begin
  if (head <> nil) then
  begin
    head^.sum := head^.data + CountSum(head^.left) + CountSum(head^.right);
    Result := head^.sum;
  end
  else
    Result := 0;
end;


var
  head, maxSumHead: PTreeEl;
  temp: string;


procedure FindMaxHead(head: PTreeEl);
begin
  if (head <> nil) then
  begin
    if (head^.sum > maxSumHead^.sum) then
      maxSumHead := head;
    FindMaxHead(head^.left);
    FindMaxHead(head^.right);
  end;
end;

procedure PrintTreeSymm(head: PTreeEl);
begin
  if (head <> nil) then
  begin
    PrintTreeSymm(head^.left);
    Writeln(head^.data);
    PrintTreeSymm(head^.right);
  end;
end;


begin
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);
  
  head := nil;
  Writeln('������� ��-�� ������ �� 1-��, � ����� ������� ������ ������');
  Readln(temp);
  temp := Trim(temp);
  while (temp <> '') do
  begin
    AddElem(head,StrToIntDef(temp,0));
    Readln(temp);
    temp := Trim(temp);
  end;

  CountSum(head);

  maxSumHead := head;
  FindMaxHead(head);

  Writeln('������������ ��� - ',maxSumHead^.sum,#10#13);
  PrintTreeSymm(maxSumHead);

  readln;
end.
