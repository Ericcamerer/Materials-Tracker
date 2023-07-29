import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    deposits: [],
  },
  getters: {
  },
  mutations: {
    ADD_DEPOSIT(state, newDeposit) {
      state.deposits.push(newDeposit);
    }
  },
  actions: {
    addDeposit({ commit}, newDeposit){
      commit('ADD_DEPOSIT', newDeposit);
    }
  },
  modules: {
  }
})
