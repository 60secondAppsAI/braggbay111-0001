<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <purchase-table
            v-if="purchases && purchases.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:purchases="purchases"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-purchases="getAllPurchases"
             >

            </purchase-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import PurchaseTable from "@/components/PurchaseTable";
import PurchaseService from "../services/PurchaseService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    PurchaseTable,
  },
  data() {
    return {
      purchases: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllPurchases(sortBy='purchaseId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await PurchaseService.getAllPurchases(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.purchases.length) {
					this.purchases = response.data.purchases;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching purchases:", error);
        }
        
      } catch (error) {
        console.error("Error fetching purchase details:", error);
      }
    },
  },
  mounted() {
    this.getAllPurchases();
  },
  created() {
    this.$root.$on('searchQueryForPurchasesChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllPurchases();
    })
  }
};
</script>
<style></style>
