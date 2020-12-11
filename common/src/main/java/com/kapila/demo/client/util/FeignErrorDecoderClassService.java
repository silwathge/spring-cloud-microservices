package com.kapila.demo.client.util;

import com.kapila.demo.exception.ClassNotFoundException;
import com.kapila.demo.exception.ServiceNotAvaiableException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoderClassService implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		System.out.println("response:"+response);
		if (response.status() == 404) {			
			return new feign.FeignException.NotFound(null,null,null);
        }else {
        	throw new ServiceNotAvaiableException("class service not available, try again later TEST");
        }
       
	}

}
