/**
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

import * as querystring from "querystring";
import * as url from "url";

import * as isomorphicFetch from "isomorphic-fetch";
import * as assign from "core-js/library/fn/object/assign";

interface Dictionary<T> { [index: string]: T; }
export interface FetchAPI { (url: string, init?: any): Promise<any>; }

const BASE_PATH = "http://localhost".replace(/\/+$/, "");

export interface FetchArgs {
    url: string;
    options: any;
}

export class BaseAPI {
    basePath: string;
    fetch: FetchAPI;

    constructor(fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) {
        this.basePath = basePath;
        this.fetch = fetch;
    }
};

export interface Category {
    "id"?: number;
    "name"?: string;
}

export interface Pet {
    "id"?: number;
    "category"?: Category;
    "name": string;
    "photoUrls": Array<string>;
    "tags"?: Array<Tag>;
    /**
     * pet status in the store
     */
    "status"?: PetStatusEnum;
}

export type PetStatusEnum = "available" | "pending" | "sold";
export interface Tag {
    "id"?: number;
    "name"?: string;
}



/**
 * PetApi - fetch parameter creator
 */
export const PetApiFetchParamCreator = {
    /** 
     * Find pet by ID
     * Returns a single pet
     * @param petId ID of pet to return
     */
    getPetById(params: {  "petId": number; }, options?: any): FetchArgs {
        // verify required parameter "petId" is set
        if (params["petId"] == null) {
            throw new Error("Missing required parameter petId when calling getPetById");
        }
        const baseUrl = `/pet/{petId}`
            .replace(`{${"petId"}}`, `${ params["petId"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "GET" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        if (contentTypeHeader) {
            fetchOptions.headers = contentTypeHeader;
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
};

/**
 * PetApi - functional programming interface
 */
export const PetApiFp = {
    /** 
     * Find pet by ID
     * Returns a single pet
     * @param petId ID of pet to return
     */
    getPetById(params: { "petId": number;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<Pet> {
        const fetchArgs = PetApiFetchParamCreator.getPetById(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
};

/**
 * PetApi - object-oriented interface
 */
export class PetApi extends BaseAPI {
    /** 
     * Find pet by ID
     * Returns a single pet
     * @param petId ID of pet to return
     */
    getPetById(params: {  "petId": number; }, options?: any) {
        return PetApiFp.getPetById(params, options)(this.fetch, this.basePath);
    }
};

/**
 * PetApi - factory interface
 */
export const PetApiFactory = function (fetch?: FetchAPI, basePath?: string) {
    return {
        /** 
         * Find pet by ID
         * Returns a single pet
         * @param petId ID of pet to return
         */
        getPetById(params: {  "petId": number; }, options?: any) {
            return PetApiFp.getPetById(params, options)(fetch, basePath);
        },
    };
};

