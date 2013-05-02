# Quick and Dirty JSON Libraries test

I found a lot of information on using different libraries for serialize/deserialize JSON, but I couldn't find an article or code where I had an evaluation of each library.

So I have decided to start implementing and trying to figure out which library is better suitable to my case.


## The Winner is Play2 Libs + Scala 2.10

Trying 3 implementations, the one that supports inner case-class and make me write less code was **Play2**. 

It is true the difference between SprayJson and Play2 were just a few keystrokes, probably someone would prefer SprayJson to avoid the huge dependecies, once Play.Libs are tight coupled with the rest of the framework.

## Important 

Hope it can help someone else! If you think this comparative isn't correct please let me know.


## Acknowledge

Thanks @mgonto for all help and guidance

____

@arjones
