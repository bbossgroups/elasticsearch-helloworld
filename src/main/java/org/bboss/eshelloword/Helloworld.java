package org.bboss.eshelloword;/*
 *  Copyright 2008 biaoping.yin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;

import java.util.Date;

public class Helloworld {
	public static void main(String[] args){
		Date date = new Date(1521788460387l);//1520584740000 1520845980000

		date = new Date(1520930340000l);
		//创建es客户端工具
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();

		//判读索引是否存在，存在返回true，不存在返回false
		boolean exist = clientUtil.existIndice("twitter");
		//判断索引类型是否存在，存在返回true，不存在返回false
		exist = clientUtil.existIndiceType("twitter",//indice
											"tweet");//type
		exist = clientUtil.existIndice("agentinfo");
		//验证环境,获取es状态
		String response = clientUtil.executeHttp("_cluster/state?pretty",ClientInterface.HTTP_GET);
//		System.out.println(response);
//		Map<String,Object> state = clientUtil.executeHttp("_cluster/state",ClientInterface.HTTP_GET,
//				new MapResponseHandler());//返回map结构
	}

}
