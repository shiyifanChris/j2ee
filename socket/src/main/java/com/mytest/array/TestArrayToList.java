package com.mytest.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shiyifan on 2018/5/14.
 *
 * @author shiyifan
 * @date 2018/05/14
 */
public class TestArrayToList {

	public static void main(String[] args) {
//		Integer[] a = {1, 2, 3, 4};
//		List<Integer> list = new ArrayList<>(Arrays.asList(a));
//		list.add(5);
//		System.out.println(list);
		List<Snow> powers = Arrays.asList(new A(), new B());
	}
}
class Snow{}
class Power extends Snow{}
class A extends Power{}
class B extends Power{}
