#!/bin/bash

# Token generado desde AWS CodeArtifact (asegúrate de que no haya espacios ni saltos de línea)
TOKEN='eyJ2ZXIiOjEsImlzdSI6MTc0NDA3MTc0MCwiZW5jIjoiQTEyOEdDTSIsInRhZyI6IkI0TmRsZGxjVlhVdFVnT0xHZEtmdXciLCJleHAiOjE3NDQxMTQ5NDAsImFsZyI6IkExMjhHQ01LVyIsIml2IjoiRFBWNkk2cmZjaTR6UzJNdyJ9.Ys9k4yHpTIwvpnBWurdrLw.HoceC1QoA-Go5HQB.z7QiFL_vi9hxQpe5OJ--x9nBKFDhI7z11Yir2W5MPieoGKbFVDWqgQXvSMrUFLv4B5djqAXZlVX1HFUdIjhU0GGPL9hchRhjmEtvLAXdrPCgUt9zBwX8SJbUzX4c57GMg1BhhxDPS7Uo5v59ZfLEA2gbNGp8uOO29GG3bxx_AeStQ0kQsotMUFHN8EdlF8DEMA8EupwVDGEWashsKubY0BFHyMkXJr5BeiabEez7puIUKFv_g-ay05Wd9f0dUyXxNzfvx1ZE6d8aG0VOdEq7wYbDxiUADLyyDti-QcvIwAasMFMtI3t5QRfDJLQlXZU-Y7x1iwJKsiD2B6710bSjpvZu7GTNEBSgQoM6OlvMt94NeHWnl8ij7lmyKqhM58ICYcLqB1Gj--fUzvGtpdHDwRVGR9N_22__F1NR0XAFIN40cl6l-aGYtgoXD43jFC89UIBhn9ulnsVs-1GCxQXBFtGvUAt81aQSTpNwka7VCaKTu6DuWowN4cio69NohluqsF8IoZ3m3mE7v8s3DNY16EvK3c1O5cfFzqjS62DZyek_bRlOqy8bLgKu2m6A7I8Gtn1LBoNZj8c3CuvaUhZhyveYXLBiX_Rej3thGWmM1iEY8oiTFnB3aVuZ_ULy4JpZi_simfxsCFSGquaNfk9KPIcLRfJ8VLOtC3uYRt_PKfhv120eo14rLYBkZAImv9nbElhg2X_koshWHx5ibj3E1AdVJNbzwIZqZkm_uj4s1MgE1-U9_6JdNU4k5KJBQbQiift8M-FnmtgQN_l5wOcmIEKvHh56AzteQ2DOWY8es4w85dJvebuefJUsRzusucPOqL8Dhyb602tb6g96v4aIFnJuU8g7d_X6kfV93UnrdLyegTtR2GXHRIyzrM5X5Poz32oJCb0NicxhQmvB8omD6dOgNIgyzlPYcFboSWyh4-RN9XvabCLDFbfaLHDgcXaSRgWX_vti6kdaMjSx_U_j.qg2znHOb312_zLZaZMNbOQ'

# Codifica aws:<TOKEN> en base64
AUTH_HEADER=$(echo -n "aws:${TOKEN}" | base64)

# URL del archivo maven-metadata.xml
URL='https://pillihuamanlib-570123367471.d.codeartifact.us-east-2.amazonaws.com/maven/pillihuaman-com-pe-lib/pillihuaman/com/pe/pillihuaman.com.pe.lib/maven-metadata.xml'

# Ejecuta la petición con curl
curl -s -H "Authorization: Basic ${AUTH_HEADER}" "$URL"
