//{ Driver Code Starts
//Initial Template for javascript
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let input_line = readLine().split(' ');
        let s = input_line[0];
        let x = input_line[1];
        let obj = new Solution();
        let ans = obj.strstr(s, x);
        if(ans==-0)
            ans=0
        console.log(ans);
    }
}

// } Driver Code Ends


//User function Template for javascript
/**
 * @param {string} s
 * @param {string} x
 * @returns {number}
*/
 
class Solution 
{
    //Function to locate the occurrence of the string x in the string s.
    strstr(s, x)
    {
        // code here
        let n = s.length;
        let m = x.length;
        
        for (let i=0; i<=n-m; i++){
            let j;
            
            for (j=0; j<m; j++){
                if (s[i+j]!==x[j]){
                    break;
                }
            }
            if (j===m){
                return i;
            }
        }
        
        return -1;
    }
}