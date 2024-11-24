package com.example.awshandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.IntegrationOfReactAndWebservicesApplication;

public class LamdaHandlerAWS implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {

	private SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
	private static final Logger logger = LoggerFactory.getLogger(LamdaHandlerAWS.class);

	@Override
	public AwsProxyResponse handleRequest(AwsProxyRequest input, Context context) {
		try {
		/*	handler = (SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>) new SpringBootProxyHandlerBuilder()
					.springBootApplication(IntegrationOfReactAndWebservicesApplication.class).asyncInit()
					.buildAndInitialize();
		*/
			handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(IntegrationOfReactAndWebservicesApplication.class);
		} catch (Exception e) {
			logger.info("Exception caught: " + e.toString());
		}
		return handler.proxy(input, context);
	}
}
