Step 1
--

To make an attempt at learning Monads I re-write the code from https://blog.jcoglan.com/2011/03/05/translation-from-haskell-to-javascript-of-selected-portions-of-the-best-introduction-to-monads-ive-ever-read/, in Java.

The code is available in the `javascripttojava` package.
I would recommend reading the blog post first and then looking at the code in the above mentioned package.

Since the Javascript code returns tuples from methods, I use a tuple library.

The example classes appear in the following order in the above mentioned blog post.
* Compose
* ComposeDebuggable
* Bind
* Unit
* Lift


Step2
--
Created an object oriented implementation of the above monad. The code
is available in the `oologgingmonad` package.

Note that `bind` is also called `flatMap`

Step3
--
Improved `flatMap` method in the `oologgingmonad` to be able to handle different result types.
The code is available in the `oologgingmonadimproved` package.

Step4
--
Added `listmonad` package.

Step5
--
But why are Monads needed? 
* From the above mentioned tutorial about the logging monad, 
"If we want to capture this logging information, it must form part of the return value."
So it's a way to capture side effects in functional programming. It seems Failure Monad, Error Monad, Reader Monad
and State Monad from https://stackoverflow.com/a/10245311/672841 all fall under this use case.

* Easy composition of functions. List Monad falls under this use case
