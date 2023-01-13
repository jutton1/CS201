Why are two passes over the input file to be compressed required when creating a compressed version of the input file?
Once to count all the characters to see which ones are the most common. A second time to create a new compressed file.

What aspects of creating the Huffman tree from counts account for that process being a greedy algorithm?
It always does the in-the-moment best decision, aka, combining the two lowest weight trees.

At a high-level, how is the tree used to create 8-bit char/chunk encodings?


What is written first, after the magic number, in the compressed file?

Why are the bits written at the end of the compressed file representing PSEUDO_EOF required?
As there is extra padding at the end of the file. We need to know when exactly we finish with the stored data.

After reading the magic number and tree, how are the bits representing compressed data read when decompressing, e.g., how many bits are read each time the compressed data is accessed?
The rest of the compressed file must be read in order to decompress the complete file.