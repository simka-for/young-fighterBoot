<template>
    <div class="v-popup">
        <div class="header">
            <span class=".font-italic font-weight-medium">Edit Product</span>
            <v-btn @click="closeForm">
                <v-icon>close</v-icon>
            </v-btn>
        </div>
        <div class="content">
            <slot></slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: "edit-form",
        methods: {
            closeForm() {
                this.$emit("closeForm")
            },

        }
    }
</script>

<style scoped>
    .v-popup {
        padding: 20px;
        width: 344px;
        background: #ffffff;
        box-shadow: 0 0 20px 0 #e7e7e7;
        z-index: 10;
    }
    .header{
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .content{
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>