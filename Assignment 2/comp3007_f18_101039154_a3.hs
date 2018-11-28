-- COMP3007 Assignment 3
-- Name: Navid Askari Nasab
-- Student ID: 101039154

import Codec.BMP
import GHC.Word
import Data.Fixed
import Data.Maybe


-- QUESTION 1
randomNumber :: Float -> Float
randomNumber n = (((2 * n) + 3) `mod'` 5) / 5
-- `mod'` from Data.Fixed was found using: https://stackoverflow.com/questions/14027865/modulus-remainder-function-for-non-integers

--QUESTION 2
data Expr = Lit Float
  | Var String
  | Plus (Expr) (Expr)
  | Minus (Expr) (Expr)
  | Mult (Expr) (Expr)
  | Div (Expr) (Expr)

--Question 3
--EVALUATES EXPRESSIONS
evaluate :: Expr -> Float
evaluate (Lit n) = n
evaluate (Plus e1 e2) = evaluate e1 + evaluate e2
evaluate (Minus e1 e2) =  evaluate e1 - evaluate e2
evaluate (Mult e1 e2) =  evaluate e1 * evaluate e2
evaluate (Div e1 e2)
  | (evaluate e2 == 0) = 0
  | otherwise = evaluate e1 / evaluate e2

--STRING REPRESENTATION OF EXPRESSIONS
stringRep :: Expr -> String
stringRep (Lit n) = show n
stringRep (Var x) = "x"
stringRep (Plus e1 e2) = "(" ++ (stringRep e1 ++ " + " ++ stringRep e2) ++ ")"
stringRep (Minus e1 e2) = "(" ++ (stringRep e1 ++ " - " ++ stringRep e2) ++ ")"
stringRep (Mult e1 e2) = "(" ++ (stringRep e1 ++ "*" ++ stringRep e2) ++ ")"
stringRep (Div e1 e2) = "(" ++ (stringRep e1 ++ "/" ++ stringRep e2) ++ ")"
