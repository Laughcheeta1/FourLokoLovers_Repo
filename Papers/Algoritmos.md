# input size required time complexity
```
n ≤ 10 -> O(n!)
n ≤ 20 -> O(2^n)
n ≤ 500 -> O(n^3)
n ≤ 5000 -> O(n^2)
n ≤ 106 -> O(n*logn) or O(n)
n is large -> O(1) or O(logn)
```


# Primality test
```java
boolean isPrime (int x ) {
    if ( x < 2) return false ;
    if ( x == 2) return true ;
    if ( x % 2 == 0) return false ;
    
    for ( int i = 3; i * i <= x ; i += 2)
        if ( x % i == 0) return false ;
    
    return true ;
}
```

# All primes of a number
```java
void primeFactors (int N ){
    for(long p = 2; p * p <= N; ++p) {
        while(N % p == 0) {
            System.out.println(p);
            N /=p ;
        }
    }
    if ( N > 1) System.out.println ( N ) ;
}
```


# Number of divisors of an integer
```java
int divisors ( int x ) {
    int nDiv = 1;
    for ( int p = 2; p * p <= x ; ++ p ) {
        int cnt = 0;
        while ( x % p == 0) {
            ++ cnt ;
            x /= p ; 
        }
        nDiv *= cnt + 1; 
    }
    
    if ( x > 1) nDiv *= 2;
    return nDiv ;
}
```


# Greatest common divisor
```java
int gcd (int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
```

# Least common multiple
```java
int lcm (int a, int b) {
    return a * (b / gcd(a, b));
}
```


# Fast exponentiation
Given integers B (base), p (power), and m (modulo) with n ≥ 0 and 0 ≤ a < m, compute a^(n) (mod m).
```java
static int fastPow (int B , int P , int M ) {
    if ( P == 0) return 1;
    if ( P == 1) return B ;
    
    if (( P & 1) == 1)
        return (( B % M ) * fastPow ((( B % M ) * ( B      % M ) ) % M , ( P - 1) / 2 , M ) % M ) % M ;
    else
        return fastPow ((( B % M ) * ( B % M ) ) % M , P / 2 , M ) ;
}
```


# Binary search
```java
int binarySearch (int lo , int hi ) { 
    while ( lo < hi ) { 
        int mid = lo + ( hi - lo ) / 2; 
        if ( p ( mid ) ) 
            hi = mid ;
        else 
            lo = mid + 1; 
    } 
    if (! p ( lo ) ) return -1; 
    return lo ; 
}
```


# Longest common subsequence
```java
int lcs ( char [] s , char [] t ) {
    int m = s.length ;
    int n = t.length ;
    
    if ( m == 0 || n == 0) return 0;
    
    int [][] dp = new int[ m + 1][ n + 1];
    
    for ( int i = 0; i <= m ; ++ i ) dp [ i ][0] = 0;
    for ( int j = 1; j <= n ; ++ j ) dp [0][ j ] = 0;
    
    for ( int i = 0; i < m ; ++ i )
        for ( int j = 0; j < n ; ++ j )
            if ( s [ i ] == t [ j ])
                dp [ i + 1][ j + 1] = dp [ i ][ j ] + 1;
            else 
                dp [ i + 1][ j + 1] = Math.max ( dp [ i + 1][ j] , dp [ i ][ j + 1]) ;
            
    return dp [ m ][ n ];
}
```

