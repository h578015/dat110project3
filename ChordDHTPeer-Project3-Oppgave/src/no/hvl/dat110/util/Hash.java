package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		byte[] bTab = entity.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			hashint =new BigInteger(md.digest(bTab));	
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		int digestLength = hashint.bitCount();
		// get the digest length
		
		// compute the number of bits = digest length * 8
		int nbBits = digestLength*8;
		// compute the address size = 2 ^ number of bits
		BigInteger addrSize = BigInteger.valueOf(2^nbBits);
		// return the address size
		
		return addrSize;
	}
	
	public static int bitSize() {
		
		int digestlen = hashint.bitLength();
		
		// find the digest length
		
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
