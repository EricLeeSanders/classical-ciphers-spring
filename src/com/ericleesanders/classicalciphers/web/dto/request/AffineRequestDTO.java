package com.ericleesanders.classicalciphers.web.dto.request;

import com.ericleesanders.classicalciphers.web.dto.cipher.AffineDTO;

/**
 * This class is needed to to maintain type information when constructing the
 * command object in the corresponding object. Without this (and directly using
 * the CipherRequestDTO<T> object on the controller) the request would fail
 * because of type erasure.
 * 
 * @author esanders
 *
 */
public class AffineRequestDTO extends CipherRequestDTO<AffineDTO> {

}
