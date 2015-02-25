package Robot;

/**
 * Created by Shai on 31/01/2015.
 */
public interface IRobot {
    void moveStepForward();
}


/*
Comments

# free text that will not be evaluated

All text that appears after a hash, '#', will not be interpreted as instructions. The robot will proceed to read the next line in the script. Use this possibility to annotate parts of the script, just for yourself, as documentation about how these parts work

Loops

repeat(n){...instructions...}
repeats the instructions between curly brackets exactly n times.

Example:

# a square of 2x2
repeat(4)
{
	forward(2)
	right
}

repeat{...instructions...}
just keeps repeating the instructions between curly brackets for ever.

Example:

# just goes forward
# (but eventually will stay hitting a wall)
repeat
{
	forward(1)
}
repeatWhile(condition){...instructions...}
repeats the instructions between curly brackets as long as the condition holds. This condition must be a perception/seeing instruction (for example frontIsClear)

Example:

# keeps going forward,
# but stops when it can't go any further
repeatWhile(frontIsClear)
{
	forward(1)
}
break
allows you to jump out of the loop (e.g. a repeat section) so it stops performing the instructions between curly brackets. The robot will resume performing the instructions left after the closing curly bracket of the loop.

Example:

# keep going forward, until you can't go any further
repeat
{
	if(frontIsObstacle)	{
		break
	}
	else
	{
		forward(1)
	}
}

toptop
If-structures

if(condition){...instructions...}
will perform the the instructions between curly brackets, only if the condition holds. Else the robot immediately steps to the instructions written after the closing curly bracket. The condition must be a perception/seeing instruction (for example: frontIsClear)

Example:

# if you see white paint on your left, make it black
if(leftIsWhite)
{
	left
	forward(1)
	paintBlack
	stopPainting
	backward(1)
	right
}

if(condition){...instructions...}else{...instructions...}
will perform the the instructions between the first pair of curly brackets, only if the condition holds. Then it will not perform the instructions of the else block (second pair of instructions). When the condition does not hold, the robot will only perform the instructions in between the second pair of curly brackets. After it performed one of the instruction blocks, it will read the instructions after the last curly bracket. The condition must be a perception/seeing instruction (for example: frontIsClear)

Example:

# if you see white paint on your left, make it black
# else drive a few steps forward
if(leftIsWhite)
{
	left
	forward(1)
	paintBlack
	stopPainting
	backward(1)
	right
}
else
{
	forward(3)
}

toptop
Logical
expressions

The conditions of if- and repeatWhile-structures is a so-called logical expression. Such an expression will result in the value true or false, which is then used to decide to step to the appropriate part of the code to resume execution.

A logical expression can be a perception instruction, e.g.: leftIsWhite. Basic instructions may also be composed with the boolean operators not, and, or.

Example:

if(leftIsWhite)
{
    left
    forward(1)
}
The condition can however also be refined to more indicate more precisely when the corresponding instructions should be executed by using (a combination of) the following operators.

Operation
Alternative
notation
Number of
arguments
Explanation
not	~	1
Negates the value of the argument :

Truth table :
not true = false
not false = true

Example:
not frontIsClear

and	&	2
Only true when both arguments are true.

Truth table:
true and true = true
true and false = false
false and true = false
false and false = false
Example:
frontIsClear and rightIsWhite
or	|	2
True when at least one of the arguments is true.

Truth table:
true or true = true
true or false = false
false or true = false
false or false = false

Example:
frontIsClear or rightIsWhite

The values true and false can also be applied directly as if it was a perception instruction.

The order of the operators is of importance (just like multiplying and adding numbers). The operation not binds strongest, followed by and, followed by or. Brackets can be used to influence the order of evaluation.

Examples:


repeatWhile(not frontIsClear and (leftIsWhite or rightIsWhite)){
    forward(1)
}

if(flipCoin and not rightIsWhite)
{
    right
    backward(1)
}

if(true and false){
    # this instruction is never executed
    forward(1)
}

toptop
Procedures

procedure name(par1, par2, ... , parN){...instructions...}
defines a new procedure with the name you want. The procedure can have zero or more parameters, which you may also give useful names. Here they are called par1, par2, . . . , parN. These are the variables you can use in the instruction between curly brackets. The code in a procedure will not be performed automatically, you have to write a 'procedure call' every time you want to perform the instructions in the definition (See next instruction).
Tip: create a new procedure when when you you use a sequence of instructions more than once.

Example:

# define how to draw a rectangle
procedure rectangle(width, height)
{
	paintWhite
	repeat(2)
	{
		forward(height)
		right
		forward(width)
		right
	}
	stopPainting
}

name(arg1, arg2, . . . , argN)
is the call to the procedure with the corresponding name and the same amount parameters as you have arguments. The argument, here called arg1, arg2, . . . , argN, are the particular values that will be used in the procedure definition.

Example:

# these instructions will be performed
forward(1)
rectangle(3,2) # a call to the 'rectangle' procedure
forward(3)
rectangle(1,4) # another call with other arguments


# this is the definition of 'rectangle'
procedure rectangle(width, height)
{
	paintWhite
	repeat(2)
	{
		forward(height)
		right
		forward(width)
		right
	}
	stopPainting
}
toptop
End

end
will cause the entire program to stop when this instruction is performed.

Example:

# stop after 5 steps, or earlier when you encounter a beacon on the right
repeat(5)
{
	forward(1)
	if(rightIsBeacon)
	{
		end # stops execution of the program
	}
}
# normal end of the program


 */