package toys.miniwooden.vzuklontest.model

import toys.miniwooden.vzuklontest.model.api.ApiUserItem


fun ApiUserItem.extInfo(): String {
    return "$this].username\n$this.email\n$this.phone"
}