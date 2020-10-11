STAVROS ANDRONIS A.M: 3181
-----------------------------------------------------------------------------------------

-- ASKHSH 1


nearest :: [Int]->Int->Int
nearest [] n = error "Empty List!Provide filled one"
nearest lista n = (elementIndex ( n + (-(minDiff lista n) ) ) lista) --This Function Calculates the index of the number who has the minimum absolute difference with given number
-- Function n + (-(minDiff lista n) : Subtracts the number N from Minimum Difference and provides The Number with the Minimum Difference
                  where elementIndex :: Int -> [Int] -> Int
                        elementIndex number []  = -1
                        elementIndex number lst = if number == last(lst) then length(lst) else elementIndex number  (init lst)

minDiff :: [Int] -> Int -> Int -- Returns  the MinDifference of the given number(n) with an ellement of a given list
minDiff [] n = error "Empty List!Provide filled one"
minDiff (h:[]) n = n - h
minDiff (h:t) n = if abs(current_dif (h:t) n) <= abs((recursive_dif t n)) then current_dif (h:t) n  else recursive_dif t n
  where current_dif s z = (z - head s)

        recursive_dif s z = (minDiff s z)

-----------------------------------------------------------------------------------------
     
-- ASKHSH 2

smooth :: [Int]->Int->[Int]
smooth s k
           | condition1 s k = []
           | condition2 k = s
           | condition3 s k = [(average k s)]
           | otherwise = ( insertInt (average k s) (smooth (tail s) k) )
           where condition1 lista number = ((length lista) < number)
                 condition2 number = (number == 1)
                 condition3 lista number = (((length lista) - number + 1) == 1)


insertInt :: Int -> [Int] -> [Int]
insertInt n (h:t) = n:h:t
insertInt n []  = [n]

add :: Int-> [Int] -> Int
add z [] = error"empty list"
add 1 lista = head lista
add z lista = (head lista) + add (z-1) (tail lista)

average :: Int -> [Int] -> Int
average x [] = error "not working"
average x (h:t) = (add x (h:t)) `div` x


 
-----------------------------------------------------------------------------------------
     
-- ASKHSH 3


swap :: String->String
swap s
      |length (splitString s) <= 1 =  s
      |otherwise = newStringConstructor (revWords (splitString s))

splitString :: String ->[[Char]]
splitString [] = [""]
splitString given_str = (splitWords given_str "" [])

splitWords :: [Char] -> [Char] -> [[Char]] -> [[Char]]
splitWords [] storeLetters splitedWords = (splitedWords ++ [storeLetters])
splitWords str storeLetters splitedWords
                    |(head str) == ' ' = (splitWords (tail str) "" (splitedWords ++ [storeLetters]))
                    |otherwise = (splitWords (tail str) (storeLetters ++ [(head str)]) splitedWords)

revWords :: [String] -> [String]
revWords lista
              |length lista == 1 = lista
              |length lista == 2 = reverse ([(lista !! 0)] ++ [(lista !! 1)])
              |otherwise = reverse ([(lista !! 0)] ++ [(lista !! 1)]) ++ revWords (tail (tail lista ))

newStringConstructor :: [String] -> String
newStringConstructor lista
                        |null (tail lista) = lista !! 0
                        |otherwise = head lista ++ " " ++ (newStringConstructor (tail lista))


-----------------------------------------------------------------------------------------
     
-- ASKHSH 4

mapi :: [u]->(u->Int->v)->[v]
mapi [] _ = []
mapi s f = (calculate f s ([1..(length s)]))

calculate :: (u->Int->v) -> [u] -> [Int] -> [v]
calculate g (h:[]) (z:[]) = g (h) (z) : []
calculate g u initialList = g (head u) (head initialList) : (calculate g (tail u) (tail initialList))
