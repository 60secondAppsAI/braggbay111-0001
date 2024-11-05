import http from "../http-common"; 

class PurchaseService {
  getAllPurchases(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/purchase/purchases`, searchDTO);
  }

  get(purchaseId) {
    return this.getRequest(`/purchase/${purchaseId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/purchase?field=${matchData}`, null);
  }

  addPurchase(data) {
    return http.post("/purchase/addPurchase", data);
  }

  update(data) {
  	return http.post("/purchase/updatePurchase", data);
  }
  
  uploadImage(data,purchaseId) {
  	return http.postForm("/purchase/uploadImage/"+purchaseId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new PurchaseService();
