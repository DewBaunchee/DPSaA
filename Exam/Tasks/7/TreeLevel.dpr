program TreeLevel;

{$APPTYPE CONSOLE}

type
  TNodePtr = ^TNode;
	TNode = record
		Data: integer;
		LeftChild, RightChild: TNodePtr;
	end;
  TSourceArr = array[0..9] of Integer;

const
  A: TSourceArr = (17, 11, 14, 12, 15, 26, 21, 19, 34, 37);

var
  Head: TNodePtr;
  lvlInput: Integer;

procedure Insert(var Node: TNodePtr; ToInsert: Integer);
	begin
	  if Node = nil then
	  begin
	    New(Node);
	    Node^.Data := ToInsert;
	    Node^.LeftChild := nil;
	    Node^.RightChild := nil;
	  end
	  else
	    if ToInsert <= Node^.Data then
	      Insert(Node^.LeftChild, ToInsert)
	    else
	      Insert(Node^.RightChild, ToInsert);
	end;

procedure FillTree(var head: TNodePtr; Arr: TSourceArr);
  var
    i: Integer;
  begin
    for i := 0 to 9 do
      Insert(head, Arr[i]);
  end;

procedure PrintTree(Node: TNodePtr; Tab: string);
  begin
    if Node <> nil then
    begin
      writeln(Tab, Node^.Data);
      if Node^.LeftChild = nil then
        Writeln(Tab, '  no L')
      else
        PrintTree(Node^.LeftChild, Tab+'  ');
      if Node^.RightChild = nil then
        Writeln(Tab, '  no R')
      else
        PrintTree(Node^.RightChild, Tab+'  ');
    end;
  end;

function CountSiblings(Head: TNodePtr; OnLevel: integer): integer;
	var
	  Count: integer;
  procedure CheckNode(node: TNodePtr; level: integer; var siblCount: integer);
	  begin
	    if (Node <> nil) then
	      if level = OnLevel then
	        siblCount := siblCount + 1
	      else
	      begin
	        CheckNode(node^.LeftChild, level + 1, siblCount);
	        CheckNode(node^.RightChild, level + 1, siblCount);
	      end;
	  end;
	begin
	  Count := 0;
	  CheckNode(Head, 0, Count);
	  Result := Count;
	end;

begin
  FillTree(Head, A);
  //PrintTree(Head, '');
  Write('Enter level: ');
  Readln(lvlInput);
  Writeln('Number of nodes on this level: ', CountSiblings(Head, lvlInput));
  readln;
end.

