Step 1
--

To make an attempt at learning Monads I re-write the code from https://blog.jcoglan.com/2011/03/05/translation-from-haskell-to-javascript-of-selected-portions-of-the-best-introduction-to-monads-ive-ever-read/, in Java.

The code will be available in the `javascripttojava` package.
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
